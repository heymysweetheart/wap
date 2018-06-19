package cs472.mum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

  // JDBC driver name and database URL
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL="jdbc:mysql://localhost:3306/entries";

  //  Database credentials
  static final String USER = "root";
  static final String PASS = "root";

  public static Connection connection;

  public static Connection getConnection() {
    if(connection == null) {
      try {
        Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }

      // Open a connection
      try {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return connection;
    } else {
      return connection;
    }
  }
}
