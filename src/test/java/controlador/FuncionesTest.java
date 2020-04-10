package controlador;

import java.sql.Date;
import modelo.Incidencia;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que realiza pruebas unitarias para los métodos que insertan y eliminan
 * una incidencias.
 * 
 * @author Hp
 */
public class FuncionesTest {

    public FuncionesTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of insertar method, of class Funciones.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Incidencia inc = new Incidencia("Producto defectuoso prueba test", new Date(2020 - 01 - 01), 1, 1, 1, 25.5F);
        boolean expResult = true;
        boolean result = Funciones.insertar(inc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of eliminarIncidencia method, of class Funciones.
     */
    @Test
    public void testEliminarIncidencia() {
        System.out.println("eliminarIncidencia");
        Integer id = 30;
        boolean expResult = true;
        boolean result = Funciones.eliminarIncidencia(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

}
