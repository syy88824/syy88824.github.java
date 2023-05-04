        
     //登入連到主頁面
        //使用者新增歌單(ok)
        //將歌曲新增至歌單中（歌單公開。全部使用者皆擁有更改歌單內容但不可更改歌單名稱）(Ok?)
        //喜愛某歌單(OK)
        //搜尋歌單(OK)
        //排名歌單(ok?)
        //歌曲占卜（亂數產生）(ok)
        //要加圖嗎？這很嚴重！
        //要分享歌單的QR code或連結嗎？不確定捏
        
        
        //https://uoclab.nccu.edu.tw/oopDB110/index.php?route=/String password = "odtjo";
     
import java.sql.*;
import java.util.Scanner;

public class Main {
	static DataFunction data = new DataFunction();
    public static void main(String[] args) {
    	String server = "jdbc:mysql://140.119.19.73:3315/";
		String database = "111306062"; // change to your own database
		String url = server + database + "?useSSL=false";
		String username = "111306062"; // change to your own user name
		String password = "hkqgr"; // change to your own password

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user name: ");
        String userName = sc.next();
        System.out.print("Enter user password: ");
        String userPassword = sc.next();

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            
            System.out.println("Connected to MySQL server.");        
            //System.out.println("Please choose one function:");
            
            boolean exit = false;
            
            String function = sc.next();
            
            while(!exit) {
             switch (function) {
              case "login":
               PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
               pstmt.setString(1, userName);
               ResultSet rs = pstmt.executeQuery();
               if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (dbPassword.equals(userPassword)) {
                 System.out.println("login successful");
                }else {
                 System.out.println("wrong password");
                }
               }else {
                System.out.println("user does not exist");
               }
               
               System.out.println("Please choose one function:");
               function = sc.next();
               break;
                     
              case "register":
               pstmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
               pstmt.setString(1, userName); 
               pstmt.setString(2, userPassword);
               pstmt.executeUpdate();
               System.out.println("user registered");
               System.out.println("Please choose one function:");
               function = sc.next();
               break;
                    
              case "delete_playlist":
                  System.out.print("Enter playlist name: ");
                  String playlistName = sc.next();
                  int userId = data.getUserId(conn, userName);

                  pstmt = conn.prepareStatement("DELETE FROM playlist WHERE playlist_name = ? AND userID = ?");
                  pstmt.setString(1, playlistName);
                  pstmt.setInt(2, userId);
                  int rowsAffected = pstmt.executeUpdate();

                  if (rowsAffected > 0) {
                      System.out.println("Playlist deleted");
                  } else {
                      System.out.println("Playlist not found");
                  }

                  System.out.println("Please choose a function:");
                  function = sc.next();
                  break;
    
              case "add_playlist":
               System.out.print("Enter playlist name: ");
               playlistName = sc.next();

               pstmt = conn.prepareStatement("INSERT INTO playlist (playlist_name, userID) VALUES (?, ?)");
               pstmt.setString(1, playlistName);
               pstmt.setInt(2, data.getUserId(conn, userName));
               pstmt.executeUpdate();
               System.out.println("playlist added");
               System.out.println("Please choose one function:");
               function = sc.next();
               break;
                     
              case "add_song_to_playlist":
               System.out.print("Enter playlist name: ");
               playlistName = sc.next();
               System.out.print("Enter song name: ");
               String songName = sc.next();

               int playlistId = data.getPlaylistId(conn, playlistName);
               if (playlistId == -1) {
                System.out.println("playlist does not exist");
                return;
               }

               int songId = data.getSongId(conn, songName);
               if (songId == -1) {
                System.out.println("song does not exist");
                return;
               }

               pstmt = conn.prepareStatement("INSERT INTO playlist_songs (playlistID, songID) VALUES (?, ?)");
               pstmt.setInt(1, playlistId);
               pstmt.setInt(2, songId);
               pstmt.executeUpdate();
               System.out.println("song added to playlist");
               System.out.println("Please choose one function:");
               function = sc.next();
               break;
                    
              case "delete_song_from_playlist":
               System.out.print("Enter playlist name: ");
               playlistName = sc.next();
               System.out.print("Enter song name: ");
               songName = sc.next();

               playlistId = data.getPlaylistId(conn, playlistName);
               if (playlistId == -1) {
                System.out.println("playlist does not exist");
                return;
               }

               songId = data.getSongId(conn, songName);
               if (songId == -1) {
                System.out.println("song does not exist");
                return;
               }

               pstmt = conn.prepareStatement("DELETE FROM playlist_songs WHERE playlistID= ? AND songID = ?");
               
               pstmt.setInt(1, playlistId);
               pstmt.setInt(2, songId);
               pstmt.executeUpdate();
               System.out.println("song deleted from playlist");
               System.out.println("Please choose one function:");
               function = sc.next();
               break;
                    
              case "search_playlist":
               
               System.out.print("Enter playlist name to search: ");
                  String searchTerm = sc.next();
                  pstmt = conn.prepareStatement("SELECT * FROM playlist WHERE playlist_name LIKE ?");
                  pstmt.setString(1, "%" + searchTerm + "%");
                  rs = pstmt.executeQuery();

                  if (!rs.next()) {
                      System.out.println("No playlists found");
                  } else {
                      System.out.println("Playlists found:");
                      do {
                          
                          pstmt = conn.prepareStatement("SELECT playlist_name , likes, hashtag FROM playlist WHERE playlist_name=?");
                          pstmt.setString(1, searchTerm);
                          rs = pstmt.executeQuery();
                          
                          showResultSet(rs);
                      } while (rs.next());
                  }

                  System.out.println("Please choose a function:");
                  function = sc.next();
                  break;
               
              case "like_playlist":
               System.out.print("Enter playlist name: ");
               playlistName = sc.next();
                 
               playlistId = data.getPlaylistId(conn, playlistName);
               if (playlistId == -1) {
                System.out.println("playlist does not exist");
                return;
               }
               pstmt = conn.prepareStatement("UPDATE playlist SET likes = likes + 1 WHERE playlistID = ?;");
               pstmt.setInt(1, playlistId);
               pstmt.executeUpdate();
                    
         
               System.out.println("playlist liked");
               System.out.println("Please choose one function:");
               function = sc.next();
               break;
               
              case "rank":
               pstmt = conn.prepareStatement("SELECT playlist_name , likes, hashtag FROM playlist ORDER BY likes DESC LIMIT 10");
               rs = pstmt.executeQuery();
               showResultSet(rs);
               
               System.out.println("Please choose a function:");
                  function = sc.next();
                  break;
                      
              case "lot-drawing":
                  pstmt = conn.prepareStatement("SELECT MAX(songID) FROM songs");
                  rs = pstmt.executeQuery();
                  int maxSongID = 0;                
                  if (rs.next()) {
                      maxSongID = rs.getInt(1);
                  }           
                  int randomSongID = (int) (Math.random() * maxSongID) + 1;
                  pstmt = conn.prepareStatement("SELECT title, artist FROM songs WHERE songID=?"); 
                  pstmt.setInt(1, randomSongID);
                  rs = pstmt.executeQuery();
                  String title = "";
                  String artist = "";
                  while(title.isBlank()) {  
                   if (rs.next()) {
                    title = rs.getString("title");
                    artist = rs.getString("artist");
                    System.out.println("Your song of the day is: " + title + " by " + artist);
                   }else {
                      System.out.println("No songs found.");
                   }
                  }

              case "exit":
               exit = true;
               break;
                    
              default:
               System.out.println("Unknown function");
               break;
            
             }
         }
         
         conn.close();

        } catch (SQLException e) {
            System.out.println("Error："+e.getMessage());
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