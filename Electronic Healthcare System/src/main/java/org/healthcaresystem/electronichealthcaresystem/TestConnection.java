package org.healthcaresystem.electronichealthcaresystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;database=ProjectDatabase;encrypt=false;";

        try {
            Connection connection = DriverManager.getConnection(url);
            if (connection != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}