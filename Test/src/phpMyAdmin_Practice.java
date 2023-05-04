import java.sql.*;

public class phpMyAdmin_Practice {
	//這是私人的database
	public static void main(String[] args) throws SQLException {
		String server = "jdbc:mysql://127.0.0.1:3307/";
		String database = "111306062"; // change to your own database
		String url = server + database + "?useSSL=false";
		String username = "root"; // change to your own user name
		String password = "syy88824"; // change to your own password
		try (Connection conn = DriverManager.getConnection(url, username, password);) {
			System.out.println("DB Connectd");
			Statement st = conn.createStatement();
			ResultSet result = null;
			String sql = "";
			sql = "SELECT * FROM `sales`";
			System.out.println("DataBase: ");
			result = st.executeQuery(sql);
			//showResultSet(result);
			
			System.out.printf("%s\t%-30s%s\t%-20s%.2f\n", args);
			while (result.next()) {
				System.out.printf("%s\t", result.getString("ID"));
				System.out.printf("%-30s", result.getString("Name"));
				System.out.printf("%s\t", result.getString("Platform"));
				System.out.printf("%-20s", result.getString("Genre"));
				System.out.printf("%.2f\n", result.getDouble("Global_Sales"));
			}
			
			result.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void showResultSet(ResultSet result) throws SQLException {
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		for (int i = 1; i <= columnCount; i++) {
			System.out.printf("%s\t", metaData.getColumnLabel(i));
		}
		System.out.println();
		
		while (result.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.printf("\t%s", result.getString(i));
			}
			System.out.println();
		}
	}
}
