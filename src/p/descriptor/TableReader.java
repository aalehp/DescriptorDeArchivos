/*
    Descriptor de Archivo

    Esta parte del programa lee el archivo de la tabla con su descriptor,
    convierte cada registro a un objeto de la clase Employee y lo guarda en
    un arreglo de éstos.

    >> Para la consulta, crear un objeto de este tipo (TableReader) y llamar al
    método 'readTable()', seguido de 'getEmployees()' para obtener toda la lista
    de empleados.
    >> Para la selección, comparar el atributo 'salary'
    >> Para la proyección, llamar al método 'select()' de la clase Employee
    (ya devuelve únicamente el valor de last_name y salary)

    ~Coria
*/

import java.io.IOException;
import java.util.ArrayList;

public class TableReader {
    public TextFile file;
    private String[] fileDescriptor; // Descriptor de Archivo
    private ArrayList<Employee> employees; // Registro de empleados

    /* !! Remover el main de esta clase al utilizar !! */
    public static void main(String[] args) throws IOException {
        TableReader reader = new TableReader("Employees.txt");
        reader.readTable();
    }

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

            employees.add(new Employee(data));
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}