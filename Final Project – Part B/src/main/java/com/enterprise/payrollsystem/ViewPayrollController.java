package com.enterprise.payrollsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Payroll;

public class ViewPayrollController  implements SceneController.SceneControllerLifecycle{
    @FXML private Label idLabel;
    @FXML private Label employeeIdLabel;
    @FXML private Label grossSalaryLabel;
    @FXML private Label overtimeHoursLabel;
    @FXML private Label basicPayLabel;
    @FXML private Label medicalAllowanceLabel;
    @FXML private Label perDayPayLabel;
    @FXML private Label totalPayableLabel;
    @FXML private Label houseRentLabel;
    @FXML private Label overtimePayLabel;
    @FXML private Label perHourPayLabel;
    @FXML private Label dateLabel;

    public static Payroll payroll;

    
    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
        idLabel.setText(Integer.toString(payroll.getPayrollId()));
        employeeIdLabel.setText(Integer.toString(payroll.getEmployeeId()));
        grossSalaryLabel.setText(Double.toString(payroll.getGrossSalary()));
        overtimeHoursLabel.setText(Double.toString(payroll.getOvertimeHours()));
        basicPayLabel.setText(Double.toString(payroll.getBasicPay()));
        medicalAllowanceLabel.setText(Double.toString(payroll.getMedicalAllowance()));
        perDayPayLabel.setText(Double.toString(payroll.getPerDayPay()));
        totalPayableLabel.setText(Double.toString(payroll.getTotalPayable()));
        houseRentLabel.setText(Double.toString(payroll.getHouseRent()));
        overtimePayLabel.setText(Double.toString(payroll.getOvertimePay()));
        perHourPayLabel.setText(Double.toString(payroll.getPerHourPay()));
        dateLabel.setText(payroll.getDate().toString());
    }
    @FXML
    public void goBack(ActionEvent event) {
        SceneController.getInstance().switchScene("dashboard");
    }

    @Override
    public void onShowing() {
        setPayroll(payroll);
    }

    @Override
    public void onHiding() {
       
    }
}