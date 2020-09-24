import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A simple data source for getting database connections.
 */
public class SimpleDataSource {
 private static String url;
 private static String username;
 private static String password;

 /**
  * Gets a connection to the database.
  * 
  * @return the database connection
  */
 public static Connection getConnection() throws SQLException {
  String server = "jdbc:mysql://140.119.19.73:9306/";
  String database = "MG10";
  String config= "?useUnicode=true&characterEncoding=utf8";
  url = server + database + config;
  username = "MG10"; 
  password = "rgan7r";
  return DriverManager.getConnection(url, username, password);
 }
}