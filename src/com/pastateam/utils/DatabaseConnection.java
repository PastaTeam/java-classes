package com.pastateam.utils;

import java.sql.*;

public class DatabaseConnection {
    private static Connection connection = null;

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/smau"; // FIXME: cambiare

    private static final String USER = "root";
    private static final String PASS = "";

    private static void createConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null)
            createConnection();

        return connection;
    }
}
