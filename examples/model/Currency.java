package com.afilini.model;

import com.afilini.DatabaseConnection;

import java.sql.*;
import java.util.List;

public class Currency extends Item {
    private final Integer ID;
    private final String name;
    private final float rate;

    public Currency(Integer id, String name, float rate) {
        ID = id;
        this.name = name;
        this.rate = rate;
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public float getRate() {
        return rate;
    }

    public static List<String> getCurrenciesNames() {
        return getList("name", "Currency");
    }

    public static Currency getCurrencyFromName(String name) {
        Connection conn = DatabaseConnection.getConnection();

        Currency answer = null;

        PreparedStatement stmt;
        try {
            String sql = "SELECT ID, rate FROM Currency WHERE name = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
                answer = new Currency(rs.getInt("ID"), name, rs.getFloat("rate"));

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answer;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
