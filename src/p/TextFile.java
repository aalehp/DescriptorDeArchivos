package p;
//Crean los lectores/escritores en buffer.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//Crean los lectores/escritores de streams de entrada/salida
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//Crean los streams de entrada/salida
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
//Excepción de Entrada/Salida
import java.io.IOException;

public class TextFile {

    private BufferedReader reader; //Flujo de lectura
    private BufferedWriter writer;

    //Constructor sin apertura de archivo.
    public TextFile() {
        reader = null;
        writer = null;
    }

    //Abrir archivo para Lectura. Recibe el nombre del archivo e intenta abrirlo para lectura.
    //Retorna <true> si lo pudo abrir, <false> si no.
    public boolean openRead(String filename) {
        try {

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
            return true;
        } catch (IOException ioe) {
            return false;
        }
    }

    //Cierra archivo para Lectura. Cierra el archivo abierto en este objeto.
    //Retorna <true> si lo pudo cerrar, <false> si no.
    public boolean closeRead() {
        try {
            reader.close();
            return true;
        } catch (IOException ioe) {
            return false;
        }
    }

    //Abrir archivo para Escritura. Recibe el nombre del archivo e intenta abrirlo para Escritura.
    //Retorna <true> si lo pudo abrir, <false> si no.
    public boolean openWrite(String filename) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
            return true;
        } catch (IOException ioe) {
            return false;
        }
    }

    //Cierra archivo para Escritura. Cierra el archivo abierto en este objeto.
    //Retorna <true> si lo pudo cerrar, <false> si no.
    public boolean closeWrite() {
        try {
            writer.close();
            return true;
        } catch (IOException ioe) {
            return false;
        }
    }

    //Leer Línea. Lee una línea del archivo de texto. Retorna la cadena o null,
    //según la función readLine(). Lanza la excepción IOException en caso de error.
    public String readLine() throws IOException {
        String s =reader.readLine();
        return s;
    }

    //Escribir Línea. Recibe un String y lo escribe al archivo, seguido de un salto de Línea
    //(line feed). Lanza una excepción IOException en caso de error.
    public void writeLine(String line) throws IOException {
        writer.write(line);
        writer.newLine();
        return;
    }

    public void leer() {

        File archivo = null;

        FileReader fr = null;

        BufferedReader br = null;

        try {

            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("C:\\Users\\Aw\\Documents\\Escuela\\Otoño 2020\\Base de Datos\\P\\src\\p\\Employees.txt");

            fr = new FileReader(archivo);

            br = new BufferedReader(fr);

            // Lectura del fichero
            System.out.println("Leyendo el contendio del archivo.txt");

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {

                if (null != fr) {

                    fr.close();

                }

            } catch (Exception e2) {

                e2.printStackTrace();

            }

        }

    }

}
