package com.example.hostel_management;
import java.sql.*;
public class DatabaseConnection {
       public Connection con;
       public Connection getConnection() {
           String dbname = "students";
           String user = "root";
           String password = "123 ";
           String url = "jdbc:mysql://localhost:3306/" + dbname;
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection(url, user, password);
           } catch (Exception e) {
               e.printStackTrace();
           }
           return con;
       }
}
