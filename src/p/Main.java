/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p;

import queryA.consulta1;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wayne
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*Pantalla ventana = new Pantalla();
        ventana.setVisible(true);
        ArrayList<Employee> tuplas = new ArrayList<>();
        ArrayList<Department> tuplasDes = new ArrayList<>();
        
        TextFile prueba = new TextFile();
        TextFile prueba2 = new TextFile();
        //System.out.println(prueba.openRead("/Employees.txt"));
        prueba.openRead("/home/wayne/NetBeansProjects/P/src/p/Employees.txt");
        prueba2.openRead("/home/wayne/NetBeansProjects/P/src/p/Departments.txt");
        
        String line = null;
        String[] fileDescriptor;
        int ii=0;
        while ((line = prueba.readLine()) != null) {
            System.out.println(line);
            tuplas.add(new Employee(line));
            ii++;
        }
        prueba.closeRead();
        
        while ((line = prueba2.readLine()) != null) {
            System.out.println(line);
            tuplasDes.add(new Department(line));
            ii++;
        }
        int cont=0;
        for (int i = 1; i < tuplas.size(); i++) {
            for (int j = 0; j < tuplasDes.size(); j++) {
                
                if (tuplas.get(i).getDepartmentID().equals(tuplasDes.get(j).getDEPARTMENT_ID())) {
                    cont++;
                    System.out.println(cont+"  "+tuplas.get(i).getEmployeeID()+"  "+tuplas.get(i).getFirstName()+"  "+
                            tuplas.get(i).getDepartmentID()+"  "+tuplasDes.get(j).getDEPARTMENT_ID()+"  "+
                            tuplasDes.get(j).getLOCATION_ID()
                            );
                }
            }
        }*/

 /*TextFile prueba = new TextFile();
        prueba.openRead("C:\\Users\\Aw\\Documents\\Escuela\\Otoño 2020\\Base de Datos\\P\\src\\p\\Employees.txt");
        String line =  prueba.readLine();
        String[] columnas = line.split(",");
        ArrayList<cabeza> cabezas = new ArrayList<>();
        
        
        
        
        for (int i = 1; i < columnas.length-2; i+=3) {
            cabezas.add(new cabeza(columnas[i], Integer.parseInt(columnas[i+1]),Integer.parseInt(columnas[i+2])));
        }
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn(" ");//n0
        
        //LEctura datos iniciales de el txt "Cabecera"
        for (int i = 0; i < cabezas.size(); i++) {
            model.addColumn(cabezas.get(i).getNombre());//Agregamos linea nombre de cada columna a la tabla
            System.out.println(cabezas.get(i).getNombre());
            
        }
        
        int i =0, cont =1;
        
        //lectura datos tabla
        while ((line = prueba.readLine()) != null){
            
            Object a[] = new Object[cabezas.size()];
            
            for (int j = 0; j < cabezas.size(); j++){
                a[j] = line.substring(cabezas.get(j).getA(), cabezas.get(j).getB());
            }
 
            model.addRow(a);

            System.out.println("nombre :"+line.substring(cabezas.get(1).getA(), cabezas.get(1).getB()));
        }*/
        Pantalla a = new Pantalla();
        a.setVisible(true);

    }

}
