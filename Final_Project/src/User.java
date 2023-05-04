import java.util.Scanner;
import java.sql.*;

public class User {	
	private static String userName;
	private static String userPassword;
	private static boolean isLoggedIn;
	public User() {
		userName = "";
		userPassword = "";
		isLoggedIn = false;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter user name: ");
		userName = sc.next();
		System.out.print("Enter user password: ");
		userPassword = sc.next();		
		
		String server = "jdbc:mysql://140.119.19.73:3315/";
		String database = "111306062"; // change to your own database
		String url = server + database + "?useSSL=false";
		String username = "111306062"; // change to your own user name
		String password = "hkqgr"; // change to your own password
		try(Connection conn = DriverManager.getConnection(url, username, password);) {
			Statement st = conn.createStatement();
			String sql = "";
			ResultSet result = null;
			System.out.print("Enter function: ");
			String function = sc.next();
			
			if (function.equals("login")) {				
				sql = "SELECT  `username` FROM `users`";
				result = st.executeQuery(sql);
				//查詢resultset時必須用next()才可將光標持續移動
				while(result.next()) {
					if(userName.equals(result.getString("username"))) { //因為前面只有選"Name"欄 所以此處column name也要選"Name" 選其他的會有bug
						//PreparedStatement可以把sql語句跟java變數拼在一起
						PreparedStatement pstLogin = conn.prepareStatement("SELECT  `password` FROM `users` WHERE `username` = ?");
						pstLogin.setString(1, userName); //JDBC的起點都是1而不是0
						result = pstLogin.executeQuery(); //pst
						result.next(); //userName對應的密碼只有一個 所以用一次next()就可以了 不需要while
						String enterPassword = result.getString("password");
						if (enterPassword.equals(userPassword)) {
							System.out.println("login successful");
							isLoggedIn = true;
							//進到主頁面
						}else {
							System.out.println("login failed");
							//showMessageDialogue(Error message)
						}												
						pstLogin.close();
						break;
					}
				}				
				//System.out.println("Insert succeed");
			}
			else if (function.equals("register")) {
				sql = "INSERT INTO `users`( `username`,`password`) VALUES "+"(?,?)";
				PreparedStatement pstRegister = conn.prepareStatement(sql);
				pstRegister.setString(1, userName);
				pstRegister.setString(2, userPassword);
				pstRegister.executeUpdate();				
			}else if(function.equals("logout")) {
				User user = new User();
				//登入後主頁面setVisible(false), 登入頁面setVisible(true)
			}
			
			//result.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}