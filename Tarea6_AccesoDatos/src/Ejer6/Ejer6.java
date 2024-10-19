package Ejer6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase Ejer6 permite crear archivos de texto para almacenar información sobre alumnos.
 * 
 * 
 * 
 * @author Aleksandar Aleksandrov
 */
public class Ejer6 {

    private static BufferedWriter bfw = null;
    private static BufferedReader bfr = null;
    private ArrayList<File> ficherosExistentes = new ArrayList<File>();
    Scanner sc = new Scanner(System.in);
    private Alumno a = new Alumno();

    /**
     * Constructor de la clase Ejer6 que inicializa la lista de archivos .txt existentes en el directorio actual.
     */
    public Ejer6() {
        File carpetaActual = new File(".");
        String[] listaFicheros = carpetaActual.list();

        for (int i = 0; i < listaFicheros.length; i++) {
            if (listaFicheros[i].contains(".txt")) {
                File fich = new File(listaFicheros[i]);
                ficherosExistentes.add(fich);
            }
        }
    }

    /**
     * Pide al usuario un nombre de archivo y crea un nuevo archivo de texto.
     * 
     * 
     * 
     * @param nombreFichero El nombre del fichero nuevo.
     */
    public void generarFicheroNuevo() {
        String nombreFichero;

        System.out.println("Dime el nombre del archivo nuevo");
        nombreFichero = sc.nextLine();

        File fich = new File(nombreFichero);

        ficherosExistentes.add(fich);

        try {
            bfw = new BufferedWriter(new FileWriter(fich, true));
            bfr = new BufferedReader(new FileReader(fich));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permite al usuario seleccionar un archivo existente para su uso.
     * 
     * 
     * @param res Es la opción elegida por el usuario.
     */
    public void seleccionarFichero() {
        File ficheroElegido;
        int res;

        System.out.println("Estos son los ficheros disponibles:");

        for (int i = 0; i < ficherosExistentes.size(); i++) {
            System.out.println(i + ". " + ficherosExistentes.get(i).getName());
        }

        System.out.println("Elige un fichero (escribe el numero)");
        res = sc.nextInt();
        sc.nextLine();
        ficheroElegido = ficherosExistentes.get(res);

        try {
            bfw = new BufferedWriter(new FileWriter(ficheroElegido, true));
            bfr = new BufferedReader(new FileReader(ficheroElegido));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Solicita al usuario la información de un alumno y la guarda en el archivo seleccionado.
     * 
     * 
     * 
     * @param texto Todos los datos del alumno.
     * @throws ParseException si la fecha de nacimiento no tiene el formato correcto.
     */
    public void cargarAlumno() throws ParseException {
        System.out.println("Dime el nia del alumno ");
        a.setNia(sc.nextInt());

        System.out.println("Dime el nombre del alumno ");
        a.setNombre(sc.next());

        System.out.println("Dime los apellidos del alumno ");
        a.setApellidos(sc.nextLine());
        sc.nextLine();

        System.out.println("Dime el genero del alumno ");
        a.setGenero(sc.next().charAt(0));
        sc.nextLine();

        System.out.println("Dime la fecha de nacimiento del alumno ");
        String fechaFormatoTexto = sc.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        a.setfNacimiento(formato.parse(fechaFormatoTexto));

        System.out.println("Dime el ciclo del alumno ");
        a.setCiclo(sc.next());

        System.out.println("Dime el curso del alumno ");
        a.setCurso(sc.next());

        System.out.println("Dime el grupo del alumno ");
        a.setGrupo(sc.next());

        String texto = "Alumno [NIA-> " + a.getNia() + ", NOMBRE-> " + a.getNombre() + ", APELLIDOS-> " + a.getApellidos() + ", GENERO-> " + a.getGenero() +
                ", FechaDeNacimiento-> " + a.getfNacimiento() + ", CICLO-> " + a.getCiclo() + ", CURSO-> " + a.getCurso() + ", GRUPO-> " + a.getGrupo() + "]\n";

        try {
            bfw.write(texto);
            bfw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee y muestra la información de todos los alumnos almacenados en el archivo seleccionado.
     * 
     * 
     * 
     * @param linea Cada linea del archivo de texto.
     */
    public void mostrarAlumnos() {
        try {
            String linea;

            while ((linea = bfr.readLine()) != null) {
                System.out.println(linea);
            }

            bfw.close();
            bfr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
