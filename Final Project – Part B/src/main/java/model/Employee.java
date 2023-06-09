package model;

import java.io.Serializable;
import java.util.Date;







public class Employee implements Serializable{
    private int id;
    private String name;
    private String position;
    private Date hireDate;

    public Employee() {
    }

    
    
    public Employee(int id, String name, String position, Date hireDate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return name; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

 
}
