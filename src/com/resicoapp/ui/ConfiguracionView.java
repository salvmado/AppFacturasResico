package com.resicoapp.ui;

import com.resicoapp.data.ContribuyenteDAO;
import com.resicoapp.model.Contribuyente;
import com.resicoapp.service.ContribuyenteService;
import javafx.geometry.Insets; // Para dar "aire" o margen a los bordes
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.SQLException;

public class ConfiguracionView extends VBox {
    private TextField txtRfc;
    private TextField txtNombre;
    private Button btnGuardar;
    private Label lblMensaje;
    private final ContribuyenteService service;

    public ConfiguracionView(ContribuyenteService service) {
        this.service = service;
        this.setSpacing(10);
        this.setPadding(new Insets(20));

        // Inicializamos los componentes
        txtRfc = new TextField();
        txtRfc.setPromptText("Ingrese su RFC");

        txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese su nombre completo ");

        btnGuardar = new Button("Guardar Contribuyente");

        lblMensaje = new Label("");

        // Los añadimos a la lista de hijos "esta" caja (VBox)
        this.getChildren().addAll(
                new Label("RFC:"), txtRfc,
                new Label("Nombre:"), txtNombre,
                btnGuardar,
                lblMensaje
        );

        btnGuardar.setOnAction(e -> {
            // 1. Extraer los datos de la interfaz
            String rfc = txtRfc.getText();
            String nombre = txtNombre.getText();

            // 2. Crear el objeto del Modelo
            Contribuyente nuevo = new Contribuyente(rfc, nombre);

            try {
                this.service.registrar(nuevo);
                lblMensaje.setText("Contribuyente guardado con éxito.");
                lblMensaje.setStyle("-fx-text-fill: green;");
                txtRfc.clear();
                txtNombre.clear();
                // Aquí podrías actualizar tu lblMensaje para avisar al usuario
            } catch (SQLException ex) {
                if (ex.getMessage().contains("UNIQUE")) {
                    lblMensaje.setText("El RFC ya está registrado.");
                    lblMensaje.setStyle("-fx-text-fill: red;");
                } else {
                    System.err.println("Error inesperado: " + ex.getMessage());
                }
            }
        });
    }
}