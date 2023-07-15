package com.example.lomi;
import java.sql.*;
public class SQLConnector {

    public Connection createConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:4306/movies", "root", "");
        return con;
    }
}
