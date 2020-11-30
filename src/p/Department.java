package p;

import java.util.ArrayList;


public class Department {

    private String DEPARTMENT_ID;
    private String DEPARTMENT_NAME;
    private String MANAGER_ID;
    private String LOCATION_ID;
    private String[] fileDescriptor;
    private ArrayList<String> data;
    
    public Department(String linea) {

        fileDescriptor = linea.split(",");
        data = new ArrayList<>();
        for (int i = 0; i < fileDescriptor.length; i++) {
            data.add(fileDescriptor[i]);
        }
        DEPARTMENT_ID = data.get(0);
        DEPARTMENT_NAME = data.get(1);
        MANAGER_ID = data.get(2);
        LOCATION_ID = data.get(3);
    }
    
    public String getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }

    public void setDEPARTMENT_ID(String DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }

    public String getDEPARTMENT_NAME() {
        return DEPARTMENT_NAME;
    }

    public void setDEPARTMENT_NAME(String DEPARTMENT_NAME) {
        this.DEPARTMENT_NAME = DEPARTMENT_NAME;
    }

    public String getMANAGER_ID() {
        return MANAGER_ID;
    }

    public void setMANAGER_ID(String MANAGER_ID) {
        this.MANAGER_ID = MANAGER_ID;
    }

    public String getLOCATION_ID() {
        return LOCATION_ID;
    }

    public void setLOCATION_ID(String LOCATION_ID) {
        this.LOCATION_ID = LOCATION_ID;
    }
    
    

    
}
