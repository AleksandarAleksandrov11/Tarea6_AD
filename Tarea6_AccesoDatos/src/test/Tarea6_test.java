package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import Ejer6.Ejer6;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

/**
 * La clase Tarea6_test contiene pruebas unitarias para la clase Ejer6,
 * asegurando todo funciona correctamente.
 * 
 * @author Aleksandar Aleksandrov
 */
@TestMethodOrder(OrderAnnotation.class)
public class Tarea6_test {

    Ejer6 e;

    /**
     * Configura el entorno de prueba antes de cada caso de prueba.
     */
    @BeforeEach
    public void setup() {
        e = new Ejer6();
    }

    /**
     * Prueba la creación de un nuevo archivo.
     * 
     * @throws IOException si hay un error al crear el archivo.
     */
    @Test
    @Order(1)
    public void testCrearFicheroNuevo() throws IOException {
        e.generarFicheroNuevo();
        
        File fichero = new File("ficheroTest.txt");
        assertTrue(fichero.exists(), "El fichero debería existir");
    }

    /**
     * Prueba que se añaden dos alumnos al archivo.
     * 
     * @throws IOException si hay un error al manejar el archivo.
     * @throws ParseException si hay un error al analizar la fecha de nacimiento.
     */
    @Test
    @Order(2)
    public void testAñadirDosAlumnos() throws IOException, ParseException {
        e.seleccionarFichero();
       
        e.cargarAlumno();
        e.cargarAlumno();
        e.mostrarAlumnos();
        
        assertTrue(new File("ficheroTest.txt").length() > 0, "El fichero debería contener datos");
    }

    /**
     * Prueba que se añade un alumno más al archivo.
     * 
     * @throws IOException si hay un error al manejar el archivo.
     * @throws ParseException si hay un error al analizar la fecha de nacimiento.
     */
    @Test
    @Order(3)
    public void testAñadirUnAlumnoMas() throws IOException, ParseException {
        e.seleccionarFichero();
        e.cargarAlumno();
        e.mostrarAlumnos();
        
        assertTrue(new File("ficheroTest.txt").length() > 0, "El fichero debería contener los alumnos");
    }

    /**
     * Prueba que se muestran todos los alumnos del archivo.
     * 
     * @throws IOException si hay un error al manejar el archivo.
     * @throws ParseException si hay un error al analizar la fecha de nacimiento.
     */
    @Test
    @Order(4)
    public void testMostrarAlumnos() throws IOException, ParseException {
        e.seleccionarFichero();
        e.mostrarAlumnos();
        
        assertTrue(new File("ficheroTest.txt").length() > 0, "El fichero debería mostrar los alumnos");
    }
}
