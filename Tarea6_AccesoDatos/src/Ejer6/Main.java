package Ejer6;

import java.text.ParseException;
import java.util.Scanner;

/**
 * La clase Main permite al usuario interactuar con el sistema
 * de gestión de alumnos a través de un menú.
 * 
 * 
 * @author Aleksandar Aleksandrov
 */
public class Main {

    /**
     * El método principal que ejecuta la aplicación.
     * 
     * @param res Es la opción elegida por el usuario.
     * @throws ParseException si hay un error al analizar la fecha de nacimiento de un alumno.
     */
    public static void main(String[] args) throws ParseException {
        Alumno a = new Alumno();
        Ejer6 e = new Ejer6();
        Scanner sc = new Scanner(System.in);
        int res = 0;

        while (res >= 0 || res < 4) {
            System.out.println();
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Genera un archivo nuevo");
            System.out.println("2. Seleccionar un archivo");
            System.out.println("3. Cargar un alumno");
            System.out.println("4. Mostrar los alumnos");
            System.out.println();
            res = sc.nextInt();

            switch (res) {
                case 1: {
                    e.generarFicheroNuevo();
                    break;
                }

                case 2: {
                    e.seleccionarFichero();
                    break;
                }

                case 3: {
                    e.cargarAlumno();
                    break;
                }

                case 4: {
                    e.mostrarAlumnos();
                    break;
                }
            }
        }
        sc.close();
    }
}
