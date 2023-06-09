package com.enterprise.payrollsystem;



import javafx.event.ActionEvent;
import utils.Operations;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Payroll;

public class ListPayrollsController   implements SceneController.SceneControllerLifecycle{

    @FXML
    private TableView<Payroll> payrollTableView;

    @FXML
    private TableColumn<Payroll, Integer> idColumn;

    @FXML
    private TableColumn<Payroll, Integer> employeeIdColumn;

    @FXML
    private TableColumn<Payroll, Double> grossSalaryColumn;

    @FXML
    private TableColumn<Payroll, Double> overtimeHoursColumn;

    @FXML
    private TableColumn<Payroll, Double> basicPayColumn;

    @FXML
    private TableColumn<Payroll, Double> medicalAllowanceColumn;

    @FXML
    private TableColumn<Payroll, Double> perDayPayColumn;

    @FXML
    private TableColumn<Payroll, Double> totalPayableColumn;

    @FXML
    private TableColumn<Payroll, Double> houseRentColumn;

    @FXML
    private TableColumn<Payroll, Double> overtimePayColumn;

    @FXML
    private TableColumn<Payroll, Double> perHourPayColumn;

    @FXML
    private TableColumn<Payroll, String> dateColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("payrollId"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        grossSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("grossSalary"));
        overtimeHoursColumn.setCellValueFactory(new PropertyValueFactory<>("overtimeHours"));
        basicPayColumn.setCellValueFactory(new PropertyValueFactory<>("basicPay"));
        medicalAllowanceColumn.setCellValueFactory(new PropertyValueFactory<>("medicalAllowance"));
        perDayPayColumn.setCellValueFactory(new PropertyValueFactory<>("perDayPay"));
        totalPayableColumn.setCellValueFactory(new PropertyValueFactory<>("totalPayable"));
        houseRentColumn.setCellValueFactory(new PropertyValueFactory<>("houseRent"));
        overtimePayColumn.setCellValueFactory(new PropertyValueFactory<>("overtimePay"));
        perHourPayColumn.setCellValueFactory(new PropertyValueFactory<>("perHourPay"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        payrollTableView.getItems().setAll(Operations.getPayrolls());
    }
    
    @FXML
    public void goBack(ActionEvent event) {
        SceneController.getInstance().switchScene("dashboard");
    }

    @Override
    public void onShowing() {
        payrollTableView.getItems().clear();
        initialize();
    }

    @Override
    public void onHiding() {
       
    }
}