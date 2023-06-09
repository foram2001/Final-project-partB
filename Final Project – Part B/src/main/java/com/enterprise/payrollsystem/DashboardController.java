package com.enterprise.payrollsystem;

import utils.Operations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.*;

import java.util.Date;
import java.util.List;

public class DashboardController implements SceneController.SceneControllerLifecycle {

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, Integer> idColumn;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> positionColumn;

    @FXML
    private TableColumn<Employee, Date> hireDateColumn;

    @FXML
    private TableColumn<Employee, Void> actionsColumn;
    List<Employee> employees = Operations.getEmployees();

    ;
    @FXML
    public void initialize() {
        // Load employees from storage

        System.out.println("Initialized");
        // Set cell value factories
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        hireDateColumn.setCellValueFactory(new PropertyValueFactory<>("hireDate"));

        // Create cell factory for actions column
        Callback<TableColumn<Employee, Void>, TableCell<Employee, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Employee, Void> call(final TableColumn<Employee, Void> param) {
                final TableCell<Employee, Void> cell = new TableCell<>() {

                    private final Button btn = new Button("Update/View Payroll");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Employee employee = getTableView().getItems().get(getIndex());
                            // You can now use the employee object to transition to the Payroll view/update scene
                            ViewPayrollController.payroll=Operations.getPayrollByEmployeeId(employee.getId());
                             SceneController.getInstance().switchScene(App.VIEW_PAYROLL_SCENE);
                            System.out.println("Selected Employee: " + employee.getName());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        actionsColumn.setCellFactory(cellFactory);

        // Fill table data
        employeeTable.getItems().addAll(employees);
    }

    @FXML
    public void addEmployee() {
        SceneController.getInstance().switchScene(App.ADD_EMPLOYEE_SCENE);
    }

    @FXML
    public void listPayrolls() {
        SceneController.getInstance().switchScene(App.LIST_PAYROLLS_SCENE);
    }

    @FXML
    public void createPayroll() {
        SceneController.getInstance().switchScene(App.CREATE_PAYROLL_SCENE);
    }

    @Override
    public void onShowing() {
        employees = Operations.getEmployees();
        employeeTable.getItems().clear();  // Clear existing items
        
        initialize();
    }

    @Override
    public void onHiding() {

    }
}
