package com.enterprise.payrollsystem;

import utils.Operations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Payroll;

import java.util.Date;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;
import model.Employee;

public class CreatePayrollController  implements SceneController.SceneControllerLifecycle{

    @FXML
    private TextField payrollIdField;

      @FXML
    private ComboBox<Employee> employeeComboBox; // change the TextField to ComboBox<Employee>

    
   

    @FXML
    private TextField grossSalaryField;

    @FXML
    private TextField overtimeHoursField;

    @FXML
    private TextField basicPayField;

    @FXML
    private TextField medicalAllowanceField;

    @FXML
    private TextField perDayPayField;

    @FXML
    private TextField totalPayableField;

    @FXML
    private TextField houseRentField;

    @FXML
    private TextField overtimePayField;

    @FXML
    private TextField perHourPayField;

      List<Employee> employeeList  = Operations.getEmployees();;
    
    
     @FXML
    public void initialize() {
        loadEmployees();
    }

    private void loadEmployees() {
      
        
        employeeComboBox.getItems().setAll(employeeList);
        employeeComboBox.setConverter(new StringConverter<Employee>() {
            @Override
            public String toString(Employee employee) {
                return employee.getName();  // display the employee's name
            }

            @Override
            public Employee fromString(String string) {
                return null;  // no need to convert to Employee here
            }
        });
    } 
    
    
    
    
    
    
    @FXML
    public void createPayroll(ActionEvent event) {
        try {
            int payrollId = Integer.parseInt(payrollIdField.getText());
           
            double grossSalary = Double.parseDouble(grossSalaryField.getText());
            double overtimeHours = Double.parseDouble(overtimeHoursField.getText());
            double basicPay = Double.parseDouble(basicPayField.getText());
            double medicalAllowance = Double.parseDouble(medicalAllowanceField.getText());
            double perDayPay = Double.parseDouble(perDayPayField.getText());
            double totalPayable = Double.parseDouble(totalPayableField.getText());
            double houseRent = Double.parseDouble(houseRentField.getText());
            double overtimePay = Double.parseDouble(overtimePayField.getText());
            double perHourPay = Double.parseDouble(perHourPayField.getText());

            
            Employee selectedEmployee = employeeComboBox.getSelectionModel().getSelectedItem();
            if (selectedEmployee == null) {
                // No employee selected, show error
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select an employee.");
                alert.showAndWait();
                return;
            }
            
            
            Payroll payroll = new Payroll();
            payroll.setPayrollId(payrollId);
            payroll.setEmployeeId(selectedEmployee.getId());
            payroll.setGrossSalary(grossSalary);
            payroll.setOvertimeHours(overtimeHours);
            payroll.setBasicPay(basicPay);
            payroll.setMedicalAllowance(medicalAllowance);
            payroll.setPerDayPay(perDayPay);
            payroll.setTotalPayable(totalPayable);
            payroll.setHouseRent(houseRent);
            payroll.setOvertimePay(overtimePay);
            payroll.setPerHourPay(perHourPay);
            payroll.setDate(new Date());

            Operations.createPayroll(payroll);

            clearFields();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Payroll Created");
            alert.setHeaderText(null);
            alert.setContentText("The payroll has been created successfully.");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while creating the payroll.");
            alert.showAndWait();
        }
    }

    @FXML
    public void goBack(ActionEvent event) {
        SceneController.getInstance().switchScene("dashboard");
    }

    private void clearFields() {
        payrollIdField.clear();
        grossSalaryField.clear();
        overtimeHoursField.clear();
        basicPayField.clear();
        medicalAllowanceField.clear();
        perDayPayField.clear();
        totalPayableField.clear();
        houseRentField.clear();
        overtimePayField.clear();
        perHourPayField.clear();
    }

    @Override
    public void onShowing() {
       employeeList = Operations.getEmployees();
       initialize();
    }

    @Override
    public void onHiding() {
       
    }
}