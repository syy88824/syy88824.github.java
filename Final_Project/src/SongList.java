import java.sql.*;
import com.mysql.cj.protocol.Resultset;
public class SongList {
	public static void main(String[] args) {
		String server = "jdbc:mysql://140.119.19.73:3315/";
		String database = "111306062"; // change to your own database
		String url = server + database + "?useSSL=false";
		String username = "111306062"; // change to your own user name
		String password = "hkqgr"; // change to your own password
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("DB Connectd");
			Statement st = conn.createStatement();
			ResultSet result = null;
			String sql = "SELECT * FROM classes Inner join `playlist` on WHERE songlist.Language = 'Korean' ";
			result = st.executeQuery(sql);
			while(result.next()) {
				System.out.println(result.getString(""));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
