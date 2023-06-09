
package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import model.*;

public class Storage {

    public static void saveUsers(List<User> users) {
        try {
            FileOutputStream fileOut = new FileOutputStream("users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    public static List<User> loadUsers() {
        List<User> users = null;
        try {
            FileInputStream fileIn = new FileInputStream("users.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            users = (List<User>) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
        } catch(ClassNotFoundException c) {
            c.printStackTrace();
        }
        return users;
    }
    
     public static void saveEmployees(List<Employee> employees) {
        try {
            FileOutputStream fileOut = new FileOutputStream("employees.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employees);
            out.close();
            fileOut.close();
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    public static List<Employee> loadEmployees() {
        List<Employee> employees = null;
        try {
            FileInputStream fileIn = new FileInputStream("employees.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            employees = (List<Employee>) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
        } catch(ClassNotFoundException c) {
            c.printStackTrace();
        }
        return employees;
    }

    public static void savePayrolls(List<Payroll> payrolls) {
        try {
            FileOutputStream fileOut = new FileOutputStream("payrolls.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(payrolls);
            out.close();
            fileOut.close();
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    public static List<Payroll> loadPayrolls() {
        List<Payroll> payrolls = null;
        try {
            FileInputStream fileIn = new FileInputStream("payrolls.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            payrolls = (List<Payroll>) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
        } catch(ClassNotFoundException c) {
            c.printStackTrace();
        }
        return payrolls;
    }
    
}
