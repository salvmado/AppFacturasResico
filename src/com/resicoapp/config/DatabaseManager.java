package com.resicoapp.config;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:resico.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initDatabase() {

        String sql = "CREATE TABLE IF NOT EXISTS contribuyentes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "rfc TEXT UNIQUE NOT NULL, " +
                "nombre TEXT NOT NULL)";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

            System.out.println("Base de datos inicializada correctamente");
        } catch (SQLException e) {
            System.err.println("Error al iniciar la base de datos: " + e.getMessage());
        }
    }
}
