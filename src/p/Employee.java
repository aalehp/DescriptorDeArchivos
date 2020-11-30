package p;

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
    private String[] fileDescriptor;
    private ArrayList<String> data;

    // Constructo
    public Employee(String linea) {

        fileDescriptor = linea.split(",");
        data = new ArrayList<>();
        for (int i = 0; i < fileDescriptor.length; i++) {
            data.add(fileDescriptor[i]);
        }
        
        employeeID = data.get(0);
        firstName = data.get(1);//Lex
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

    Employee(ArrayList<String> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    /* Métodos */
    @Override
    public String toString() {
        return employeeID + "\t" + firstName + "\t" + lastName + "\t" + email + "\t" + phoneNumber + "\t" + hireDate + "\t" + jobID + "\t" + salary + "\t" + commissionPCT + "\t" + managerID + "\t" + departmentID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCommissionPCT() {
        return commissionPCT;
    }

    public void setCommissionPCT(String commissionPCT) {
        this.commissionPCT = commissionPCT;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    // Método de selección para el query.
    // Retorna solo el apellido (lastName) y el salario (salary) en un arreglo.
    public String[] select() {
        String[] query = {employeeID,firstName, salary};
        return query;   
    }
}
