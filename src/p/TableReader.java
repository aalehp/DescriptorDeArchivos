/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableReader {

    public TextFile file;
    private String[] fileDescriptor; // Descriptor de Archivo
    private ArrayList<Employee> employees; // Registro de empleados

    /* !! Remover el main de esta clase al utilizar !! */
    // Constructor
    public TableReader(String filename) throws IOException {
        file = new TextFile();
        file.openRead(filename);
        fileDescriptor = file.readLine().split(",");
        employees = new ArrayList<>();
    }

    // Lee el archivo de la tabla.
    // Convierte cada registro a un objeto de la clase Employee.
    // Se guarda únicamente el valor significativo (se remueven espacios)
    public void readTable() throws IOException {
        String line = null;
        while ((line = file.readLine()) != null) {
            ArrayList<String> data = new ArrayList<>();
            for (int i = 0; i < 11; i++) {
                // Límites para cortar la cadena de la tupla (obtenidos del descriptor)
                int lowBound = Integer.parseInt(fileDescriptor[i * 3 + 2]);
                int highBound = Integer.parseInt(fileDescriptor[i * 3 + 3]);

                data.add(line.substring(lowBound - 1, highBound).replace(" ", ""));
            }

            employees.add(new Employee(""));
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static DefaultTableModel creamodelo(String from) throws IOException {
        TextFile prueba = new TextFile();
        prueba.openRead("C:\\Users\\Aw\\Documents\\Escuela\\Otoño 2020\\Base de Datos\\DescriptorDeArchivos\\src\\p\\" + from + ".txt");
        String line = prueba.readLine();
        String[] columnas = line.split(",");
        ArrayList<cabeza> cabezas = new ArrayList<>();

        for (int i = 1; i < columnas.length - 2; i += 3) {
            cabezas.add(new cabeza(columnas[i], Integer.parseInt(columnas[i + 1]), Integer.parseInt(columnas[i + 2])));
        }

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn(" ");//n0

        //LEctura datos iniciales de el txt "Cabecera"
        for (int i = 0; i < cabezas.size(); i++) {
            model.addColumn(cabezas.get(i).getNombre());//Agregamos linea nombre de cada columna a la tabla
            //System.out.println(cabezas.get(i).getNombre());

        }

        int i = 0, cont = 1;

        //lectura datos tabla
        while ((line = prueba.readLine()) != null) {

            Object a[] = new Object[cabezas.size() + 1];

            a[0] = cont;
            //System.out.println(cabezas.size());

            for (int j = 0; j < cabezas.size(); j++) {
                a[j + 1] = line.substring(cabezas.get(j).getA(), cabezas.get(j).getB());
            }

            model.addRow(a);

            //System.out.println("nombre :"+line.substring(cabezas.get(1).getA(), cabezas.get(1).getB()));
            cont++;
        }

        prueba.closeRead();
        return model;
    }

    public static DefaultTableModel seleccion(String from, String where) throws IOException {
        TextFile prueba = new TextFile();
        prueba.openRead("C:\\Users\\Aw\\Documents\\Escuela\\Otoño 2020\\Base de Datos\\DescriptorDeArchivos\\src\\p\\" + from + ".txt");
        String line = prueba.readLine();
        String[] columnas = line.split(",");
        ArrayList<cabeza> cabezas = new ArrayList<>();
        String wheretupla = null, whereoperator = null, wheredat = null;

        int n = 0, f = 0, b = 0;

        while (n != where.length() + 1) {

            if (where.substring(f, n).contains(" ") && b == 0) {
                wheretupla = where.substring(f, n - 1);
                f = n;
                b++;

            } else if (where.substring(f, n).contains(" ") && b == 1) {
                whereoperator = where.substring(f, n);
                f = n;
                b++;

            } else if (where.substring(f, n).contains(" ") && b == 2) {
                wheredat = "  " + where.substring(f, n - 1);
                f = n;
                b++;
            }

            n++;
        }

        //System.out.println(wheretupla+" "+whereoperator+" "+wheredat);
        for (int i = 1; i < columnas.length - 2; i += 3) {
            cabezas.add(new cabeza(columnas[i], Integer.parseInt(columnas[i + 1]), Integer.parseInt(columnas[i + 2])));
        }

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn(" ");//n0

        //LEctura datos iniciales de el txt "Cabecera"
        for (int i = 0; i < cabezas.size(); i++) {
            model.addColumn(cabezas.get(i).getNombre());//Agregamos linea nombre de cada columna a la tabla
            //System.out.println(cabezas.get(i).getNombre());

        }

        int i = 0, cont = 1;

        //lectura datos tabla
        while ((line = prueba.readLine()) != null) {

            Object a[] = new Object[cabezas.size() + 1];

            a[0] = cont;

            for (int j = 0; j < cabezas.size(); j++) {

                if (wheretupla.contains(cabezas.get(j).getNombre())) {
                    if (line.substring(cabezas.get(j).getA(), cabezas.get(j).getB()).contains(wheredat)) {
                        a[j + 1] = line.substring(cabezas.get(j).getA(), cabezas.get(j).getB()) + "*";
                    } else {
                        a[j + 1] = line.substring(cabezas.get(j).getA(), cabezas.get(j).getB());
                    }

                } else {
                    a[j + 1] = line.substring(cabezas.get(j).getA(), cabezas.get(j).getB());
                }

            }

            model.addRow(a);

            //System.out.println("nombre :"+line.substring(cabezas.get(1).getA(), cabezas.get(1).getB()));
            cont++;
        }

        prueba.closeRead();
        return model;
    }

    public static DefaultTableModel proyeccion(String select, String from, String where) throws IOException {
        TextFile prueba = new TextFile();
        prueba.openRead("C:\\Users\\Aw\\Documents\\Escuela\\Otoño 2020\\Base de Datos\\DescriptorDeArchivos\\src\\p\\" + from + ".txt");
        String line = prueba.readLine();
        String[] columnas = line.split(",");
        String[] columnas2 = select.split(",");
        ArrayList<cabeza> cabezas = new ArrayList<>();
        String wheretupla = null, whereoperator = null, wheredat = null;

        int n = 0, f = 0, b = 0;

        while (n != where.length() + 1) {

            if (where.substring(f, n).contains(" ") && b == 0) {
                wheretupla = where.substring(f, n - 1);
                f = n;
                b++;

            } else if (where.substring(f, n).contains(" ") && b == 1) {
                whereoperator = where.substring(f, n);
                f = n;
                b++;

            } else if (where.substring(f, n).contains(" ") && b == 2) {
                wheredat = "  " + where.substring(f, n - 1);
                f = n;
                b++;
            }

            n++;
        }

        //System.out.println(wheretupla+" "+whereoperator+" "+wheredat);
        for (int i = 1; i < columnas.length - 2; i += 3) {
            cabezas.add(new cabeza(columnas[i], Integer.parseInt(columnas[i + 1]), Integer.parseInt(columnas[i + 2])));
        }

        DefaultTableModel model = new DefaultTableModel();
        DefaultTableModel model2 = new DefaultTableModel();

        model.addColumn(" ");//n0

        //LEctura datos iniciales de el txt "Cabecera"
        for (int i = 0; i < cabezas.size(); i++) {
            model.addColumn(cabezas.get(i).getNombre());//Agregamos linea nombre de cada columna a la tabla
            //System.out.println(cabezas.get(i).getNombre());

        }

        model2.addColumn(" ");
        for (int i = 0; i < columnas2.length; i++) {
            model2.addColumn(columnas2[i]);//Agregamos linea nombre de cada columna a la tabla
            //System.out.println(cabezas.get(i).getNombre());

        }

        int i = 0, cont = 1;

        //lectura datos tabla
        while ((line = prueba.readLine()) != null) {

            Object a[] = new Object[cabezas.size() + 1];

            a[0] = cont;

            for (int j = 0; j < cabezas.size(); j++) {

                if (wheretupla.contains(cabezas.get(j).getNombre())) {
                    if (line.substring(cabezas.get(j).getA(), cabezas.get(j).getB()).contains(wheredat)) {
                        a[j + 1] = line.substring(cabezas.get(j).getA(), cabezas.get(j).getB()) + "*";
                    } else {
                        a[j + 1] = line.substring(cabezas.get(j).getA(), cabezas.get(j).getB());
                    }

                } else {
                    a[j + 1] = line.substring(cabezas.get(j).getA(), cabezas.get(j).getB());
                }

            }

            model.addRow(a);

            //System.out.println("nombre :"+line.substring(cabezas.get(1).getA(), cabezas.get(1).getB()));
            cont++;
        }

        Object c[] = new Object[5];

        int l = 0;
        cont = 1;

        for (int j = 0; j < (columnas2.length); j++) {
            c[0] = cont;
            c[1] = model.getValueAt(j, 1);
            c[2] = model.getValueAt(j, 2);
            c[3] = model.getValueAt(j, 8);
            cont++;
            model2.addRow(c);
        }

        prueba.closeRead();

        return model2;

    }
}
