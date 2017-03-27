package com.afilini.model;

import com.afilini.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Exports {
    public static void addExport(String country, String product, int addValue) {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt;

        try {
            String sql = "INSERT INTO Export (country, product, value) VALUES (?, ?, ?) " +
                    "ON DUPLICATE KEY UPDATE value = value + ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, country);
            stmt.setString(2, product);
            stmt.setInt(3, addValue);
            stmt.setInt(4, addValue);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> getExportsForCountry(String country) {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt;

        Map<String, Integer> answer = new HashMap<>();

        try {
            String sql = "SELECT product, value FROM Export WHERE country = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, country);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String product = rs.getString("product");
                Integer value = rs.getInt("value");

                answer.put(product, value);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answer;
    }
}
