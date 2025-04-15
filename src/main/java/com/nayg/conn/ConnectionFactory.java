package com.nayg.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/jdbctest";
        String user = "postgres";
        String password = "2912";

        return DriverManager.getConnection(url, user, password);
    }
}
