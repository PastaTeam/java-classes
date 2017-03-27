package com.afilini.model;

import com.afilini.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

abstract class Item {
    static List<String> getList(String columnName, String tableName) {
        List<String> items = new LinkedList<>();

        Connection conn = DatabaseConnection.getConnection();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT DISTINCT " + columnName + " FROM " + tableName;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String item = rs.getString(columnName);
                items.add(item);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return items;
    }
}
