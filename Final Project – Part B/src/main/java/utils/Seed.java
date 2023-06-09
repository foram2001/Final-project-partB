
package utils;

import java.util.Date;
import model.*;


public class Seed {
    public static void seed() {
        // Provide seed data
        User admin = new User(1, "admin", "admin", "Admin");
        User user = new User(2, "user", "user", "User");
        Operations.register(admin);
        Operations.register(user);

        Employee john = new Employee(1, "John Doe", "Manager", new Date());
        Employee jane = new Employee(2, "Jane Doe", "Assistant Manager", new Date());
        Operations.createEmployee(john);
        Operations.createEmployee(jane);

        Payroll johnPayroll = new Payroll(1, 1, 5000.00, 5, 4000.00, 100.00, 200.00,
                5300.00, 200.00, 100.00, 20.00, new Date());
        Operations.createPayroll(johnPayroll);

        // Store the data
        Storage.saveUsers(Operations.getUsers());
        Storage.saveEmployees(Operations.getEmployees());
        Storage.savePayrolls(Operations.getPayrolls());

        // Retrieve the data
        Operations.setUsers(Storage.loadUsers());
        Operations.setEmployees(Storage.loadEmployees());
        Operations.setPayrolls(Storage.loadPayrolls());

        // Test the operations
        System.out.println("Users: " + Operations.getUsers());
        System.out.println("Employees: " + Operations.getEmployees());
        System.out.println("Payrolls: " + Operations.getPayrolls());

        User verifiedUser = Operations.verifyUser("admin", "admin");
        System.out.println("Verified User: " + verifiedUser);

        Employee updatedJohn = new Employee(1, "John Doe Updated", "Manager Updated", new Date());
        Operations.updateEmployee(updatedJohn);
        System.out.println("Updated Employees: " + Operations.getEmployees());

        Operations.deleteEmployee(2);
        System.out.println("After Deletion Employees: " + Operations.getEmployees());

        Payroll updatedJohnPayroll = new Payroll(1, 1, 6000.00, 6, 5000.00, 200.00, 300.00,
                6300.00, 300.00, 200.00, 30.00, new Date());
        Operations.updatePayroll(updatedJohnPayroll);
        System.out.println("Updated Payrolls: " + Operations.getPayrolls());

        Operations.deletePayroll(1);
        System.out.println("After Deletion Payrolls: " + Operations.getPayrolls());
    }
}