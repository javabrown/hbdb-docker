package com.javabrown.db.hbdb;

import java.sql.*;

public class DbConnection {
   public void testConnection(){
      try {
         connect();  
      }
      catch(Exception ex) {
         ex.printStackTrace();
      }
   }

   public void connect() throws Exception {
      Class.forName("com.mysql.jdbc.Driver");
      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/rk", "root", "");

      Statement st = c.createStatement();
      ResultSet rs = st.executeQuery("select * from student");

      while(rs.next()){
         System.out.println(rs.getInt(1) + "     " + rs.getString(2));
      }

      c.close();
   }
}
