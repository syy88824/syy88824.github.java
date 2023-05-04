import java.sql.*;
public class Lab18 {
	public static void main(String[] args) {
		String server = "jdbc:mysql://140.119.19.73:3315/";
		String database = "111306062"; // change to your own database
		String url = server + database + "?useSSL=false";
		String username = "111306062"; // change to your own user name
		String password = "hkqgr"; // change to your own password
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("DB Connectd");
			java.sql.Statement st = conn.createStatement();
			ResultSet result = null;
			String query;			
		//Task 1
			System.out.println("Query 1:");
			query = "SELECT ID,Name,Birth,Position FROM Twice WHERE POSITION = 'Vocal'";	
			result = st.executeQuery(query);
			showResultSet(result);	
			System.out.println("-".repeat(80));		
		//Task 2
			query = "INSERT INTO `Twice` (ID,Name,Birth,Height,Position) VALUE (10,\"Shihyu\",\"1999-01-11\",163.78,\"ACE\")";
			st.executeUpdate(query);	
		//Task 3
			query = "SELECT * FROM Twice WHERE Birth > '1998-12-31'";
			System.out.println("Query 2:");
			result = st.executeQuery(query);
			showResultSet(result);
			System.out.println("-".repeat(80));
		//Task 4
			query = "DELETE FROM `Twice` WHERE Name = 'Shihyu'";
			st.execute(query);
		//Task 5
			query = "SELECT ID,Name,Height FROM `Twice` WHERE Height > 161.0 AND Height < 165.0";
			System.out.println("Query 3:");
			result = st.executeQuery(query);
			showResultSet(result);
			
			if (result != null) {
				result.close();
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// define this static method in your Lab18 class
	public static void showResultSet(ResultSet result) throws SQLException {
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		for (int i = 1; i <= columnCount; i++) {
			System.out.printf("%15s", metaData.getColumnLabel(i));
		}
		System.out.println();
		while (result.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.printf("%15s", result.getString(i));
			}
			System.out.println();
		}
	}

}
