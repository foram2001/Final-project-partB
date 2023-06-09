
package utils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.*;

import model.*;

public class Operations {
    
    // Seed Data
    private static List<User> users = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    private static List<Payroll> payrolls = new ArrayList<>();

     static {
        // Load data from the disk into memory
        List<User> savedUsers = Storage.loadUsers();
        if (savedUsers != null) {
            users = savedUsers;
        }

        List<Employee> savedEmployees = Storage.loadEmployees();
        if (savedEmployees != null) {
            employees = savedEmployees;
        }

        List<Payroll> savedPayrolls = Storage.loadPayrolls();
        if (savedPayrolls != null) {
            payrolls = savedPayrolls;
        }
    }

    
       // Getters and Setters
    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        Operations.users = users;
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(List<Employee> employees) {
        Operations.employees = employees;
    }

    public static List<Payroll> getPayrolls() {
        return payrolls;
    }

    public static void setPayrolls(List<Payroll> payrolls) {
        Operations.payrolls = payrolls;
    }
    
    
    
    
    // User-related operations
    public static User register(User user) {
        users.add(user);
        Storage.saveUsers(users);
        
        return user;
    }

    public static User verifyUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // Employee-related operations
    public static Employee createEmployee(Employee employee) {
        employees.add(employee);
        Storage.saveEmployees(employees);
        return employee;
    }

   

    public static boolean updateEmployee(Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == updatedEmployee.getId()) {
                employee.setName(updatedEmployee.getName());
                employee.setPosition(updatedEmployee.getPosition());
                employee.setHireDate(updatedEmployee.getHireDate());
                Storage.saveEmployees(employees);
                return true;
            }
        }
        return false;
    }

    public static boolean deleteEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                Storage.saveEmployees(employees);
                return true;
            }
        }
        return false;
    }

    // Payroll-related operations
    public static Payroll createPayroll(Payroll payroll) {
        payrolls.add(payroll);
        Storage.savePayrolls(payrolls);
        return payroll;
    }


    public static boolean updatePayroll(Payroll updatedPayroll) {
        for (Payroll payroll : payrolls) {
            if (payroll.getPayrollId() == updatedPayroll.getPayrollId()) {
                // Assuming setters exist in your Payroll class
                payroll.setGrossSalary(updatedPayroll.getGrossSalary());
                payroll.setOvertimeHours(updatedPayroll.getOvertimeHours());
                payroll.setBasicPay(updatedPayroll.getBasicPay());
                payroll.setMedicalAllowance(updatedPayroll.getMedicalAllowance());
                payroll.setPerDayPay(updatedPayroll.getPerDayPay());
                payroll.setTotalPayable(updatedPayroll.getTotalPayable());
                payroll.setHouseRent(updatedPayroll.getHouseRent());
                payroll.setOvertimePay(updatedPayroll.getOvertimePay());
                payroll.setPerHourPay(updatedPayroll.getPerHourPay());
                payroll.setDate(updatedPayroll.getDate());
                Storage.savePayrolls(payrolls);
                return true;
            }
        }
        return false;
    }
// Payroll-related operations

public static Payroll getPayrollByEmployeeId(int employeeId) {
    for (Payroll payroll : payrolls) {
        if (payroll.getEmployeeId() == employeeId) {
            return payroll;
        }
    }
    return null;
}

    public static boolean deletePayroll(int payrollId) {
        for (Payroll payroll : payrolls) {
            if (payroll.getPayrollId() == payrollId) {
                payrolls.remove(payroll);
                Storage.savePayrolls(payrolls);
                return true;
            }
        }
        return false;
    }
}