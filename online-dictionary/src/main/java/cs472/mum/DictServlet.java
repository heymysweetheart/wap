package cs472.mum;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DictServlet extends HttpServlet {

  // JDBC driver name and database URL
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL="jdbc:mysql://localhost:3306/entries";

  //  Database credentials
  static final String USER = "root";
  static final String PASS = "root";

  public String resultSetToJson(ResultSet rs) throws SQLException,JSONException
  {
    // json数组
    JSONArray array = new JSONArray();

    // 获取列数
    ResultSetMetaData metaData = rs.getMetaData();
    int columnCount = metaData.getColumnCount();

    // 遍历ResultSet中的每条数据
    while (rs.next()) {
      JSONObject jsonObj = new JSONObject();

      // 遍历每一列
      for (int i = 1; i <= columnCount; i++) {
        String columnName =metaData.getColumnLabel(i);
        String value = rs.getString(columnName);
        jsonObj.put(columnName, value);
      }
      array.put(jsonObj);
    }

    return array.toString();
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    String word = request.getParameter("word");

    // Set response content type
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Database Result";

    Statement stmt = null;
    Connection conn = null;
    PreparedStatement statement = null;
    try {
      // Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      // Open a connection
    conn = DriverManager.getConnection(DB_URL, USER, PASS);

      // Execute SQL query
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM entries where word = ?";
      statement = conn.prepareStatement(sql);
      statement.setString(1, word);
      ResultSet resultSet = statement.executeQuery();

//      while(resultSet.next()) {
//        out.println("Word: " + resultSet.getString(1) + " Type: " + resultSet.getString(2) + " Definition: " +
//            resultSet.getString(3) + "\n");
//      }

      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/json; charset=utf-8");
      PrintWriter output = null;
      try {
        output = response.getWriter();
        String json = resultSetToJson(resultSet);
        System.out.println("Response: " + json);
        output.write(json);
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (out != null) {
          out.close();
        }
      }
      resultSet.close();
      stmt.close();
      conn.close();
    } catch(SQLException se) {
      //Handle errors for JDBC
      se.printStackTrace();
    } catch(Exception e) {
      //Handle errors for Class.forName
      e.printStackTrace();
    } finally {
      //finally block used to close resources
      try {
        if(stmt!=null)
          stmt.close();
      } catch(SQLException se2) {
      } // nothing we can do
      try {
        if(conn!=null)
          conn.close();
      } catch(SQLException se) {
        se.printStackTrace();
      } //end finally try
    } //end try
  }
}
