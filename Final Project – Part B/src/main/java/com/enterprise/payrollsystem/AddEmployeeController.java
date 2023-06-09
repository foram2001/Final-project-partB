package com.enterprise.payrollsystem;

import utils.Operations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Employee;
import java.util.Date;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AddEmployeeController  implements SceneController.SceneControllerLifecycle{

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField positionField;

    @FXML
    public void addEmployee(ActionEvent event) {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String position = positionField.getText();

            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setPosition(position);
            employee.setHireDate(new Date());

            Operations.createEmployee(employee);

            clearFields();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Employee Added");
            alert.setHeaderText(null);
            alert.setContentText("The employee has been added successfully.");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while adding the employee.");
            alert.showAndWait();
        }
    }

    @FXML
    public void goBack(ActionEvent event) {
       SceneController.getInstance().switchScene("dashboard");
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        positionField.clear();
    }

    @Override
    public void onShowing() {
 
    }

    @Override
    public void onHiding() {
      
    }
}