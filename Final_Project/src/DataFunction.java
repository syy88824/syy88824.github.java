import java.io.*;
import java.net.*;
import java.sql.*;

public class DataFunction {
	String server = "jdbc:mysql://140.119.19.73:3315/";
	String database = "111306062"; // change to your own database
	String url = server + database + "?useSSL=false";
	String username = "111306062"; // change to your own user name
	String password = "hkqgr"; // change to your own password
	Connection conn;
	PreparedStatement pst;
	ResultSet result;

	public int getUserId(Connection conn, String userName) {
		int value = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			String sql = "SELECT `user_ID` FROM `users` WHERE `username` = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			result = pst.executeQuery();
			result.next();
			value = result.getInt(1);
		}catch(SQLException e) {
            System.out.println(e.getMessage());
		}finally {
			return value;
		}
    }
	public int getPlaylistId(Connection conn, String playlistName) {
		int value = -1;
		try {
			conn = DriverManager.getConnection(url, username, password);
			String sql = "SELECT `playlist_ID` FROM `playlist` WHERE `ListName` = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, playlistName);
			result = pst.executeQuery();
			result.next();
			value = result.getInt(1);
		}catch(SQLException e) {
            System.out.println(e.getMessage());
		}finally {
			return value;
		}
    }
	public int getSongId(Connection conn, String songName) {
		int value = -1;
		try {
			conn = DriverManager.getConnection(url, username, password);
			String sql = "SELECT `song_ID` FROM `songlist` WHERE `Name` = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, songName);
			result = pst.executeQuery();
			result.next();
			value = result.getInt(1);
		}catch(SQLException e) {
            System.out.println(e.getMessage());
		}finally {
			return value;
		}
	}
}
