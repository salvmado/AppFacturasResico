import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    @Test
    void testConexionBaseDeDatos() {
        String url = "jdbc:sqlite:resico.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            // Si llegamos aquí, la conexión se abrió
            System.out.println("Conexión exitosa a: " + url);

            // Verificamos que el objeto 'conn' no sea nulo
            assertNotNull(conn, "La conexión no debería ser nula");

        } catch (SQLException e) {
            // Si hay un error, el test fallará con este mensaje
            fail("No se pudo conectar a la base de datos: " + e.getMessage());
        }
    }
}

// Resultado de la prueba:
// Conexión exitosa a: jdbc:sqlite:resico.db
// Process finished with exit code 0