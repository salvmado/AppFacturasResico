package com.resicoapp.ui;

import com.resicoapp.config.DatabaseManager; // Importamos tu clase de configuración
import com.resicoapp.data.ContribuyenteDAO;
import com.resicoapp.service.ContribuyenteService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // Ejemplo de cómo quedaría tu método start en Main.java:
    @Override
    public void start(Stage stage) {
        DatabaseManager.initDatabase(); // Inicializamos DB

        // Ensamblaje de capas (Inyección de Dependencias manual)
        ContribuyenteDAO dao = new ContribuyenteDAO();
        ContribuyenteService service = new ContribuyenteService(dao);
        ConfiguracionView vista = new ConfiguracionView(service);

        Scene scene = new Scene(vista, 450, 400);
        stage.setTitle("Configuración de Contribuyente");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}