package com.resicoapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseConnectionTest {

    @Test
    void testForzadoAFallar() {
        // Mi mentor quiere ver un fallo, así que le daremos uno
        System.out.println("Ejecutando prueba de conexión...");
        assertTrue(false, "Este test falla a propósito para el Ticket #1");
    }
}