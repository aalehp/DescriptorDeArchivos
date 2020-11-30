/*
    Clase Employee

    Guarda los datos de un empleado.
    Contiene ya un método especial para el query soliticado (únicamente proyección).

    ~Coria
*/

import java.util.ArrayList;

public class Employee {
    // Atributos
    private String employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private String jobID;
    private String salary;
    private String commissionPCT;
    private String managerID;
    private String departmentID;

    // Constructor
    public Employee(ArrayList<String> data) {
        employeeID = data.get(0);
        firstName = data.get(1);
        lastName = data.get(2);
        email = data.get(3);
        phoneNumber = data.get(4);
        hireDate = data.get(5);
        jobID = data.get(6);
        salary = data.get(7);
        commissionPCT = data.get(8);
        managerID = data.get(9);
        departmentID = data.get(10);
    }


    /* Métodos */
    @Override
    public String toString() {
        return employeeID + "\t" + firstName + "\t" + lastName + "\t" + email + "\t" + phoneNumber + "\t" + hireDate + "\t" + jobID + "\t" + salary + "\t" + commissionPCT + "\t" + managerID + "\t" + departmentID;
    }

    // Método de selección para el query.
    // Retorna solo el apellido (lastName) y el salario (salary) en un arreglo.
    public String[] select() {
        String[] query = {lastName, salary};
        return query;
    }
}