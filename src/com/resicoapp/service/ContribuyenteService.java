package com.resicoapp.service;

import com.resicoapp.data.ContribuyenteDAO;
import com.resicoapp.model.Contribuyente;
import java.sql.SQLException;

public class ContribuyenteService {
    private final ContribuyenteDAO dao;

    // Inyectamos la dependencia manualmente
    public ContribuyenteService(ContribuyenteDAO dao) {
        this.dao = dao;
    }

    public void registrar(Contribuyente c) throws SQLException {
        // Aquí podrías agregar validaciones de negocio en el futuro
        // Por ejemplo: verificar que el RFC tenga la longitud correcta
        dao.guardar(c);
    }
}