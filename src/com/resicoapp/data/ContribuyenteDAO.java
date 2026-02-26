package com.resicoapp.data;

import com.resicoapp.config.DatabaseManager;
import com.resicoapp.model.Contribuyente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContribuyenteDAO {

    public void guardar(Contribuyente c) throws SQLException {
        String sql = "INSERT INTO contribuyentes (rfc, nombre) VALUES (?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, c.getRfc());
            pstmt.setString(2, c.getNombre());

            pstmt.executeUpdate();
        }
    }
}
