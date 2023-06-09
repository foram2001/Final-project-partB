
package model;

import java.io.Serializable;
import java.util.Date;




public class Payroll implements Serializable{
    private int payrollId;
    private int employeeId;
    private double grossSalary;
    private double overtimeHours;
    private double basicPay;
    private double medicalAllowance;
    private double perDayPay;
    private double totalPayable;
    private double houseRent;
    private double overtimePay;
    private double perHourPay;
    private Date date;

    public Payroll() {
    }

    public Payroll(int payrollId, int employeeId, double grossSalary, double overtimeHours, double basicPay, double medicalAllowance, double perDayPay, double totalPayable, double houseRent, double overtimePay, double perHourPay, Date date) {
        this.payrollId = payrollId;
        this.employeeId = employeeId;
        this.grossSalary = grossSalary;
        this.overtimeHours = overtimeHours;
        this.basicPay = basicPay;
        this.medicalAllowance = medicalAllowance;
        this.perDayPay = perDayPay;
        this.totalPayable = totalPayable;
        this.houseRent = houseRent;
        this.overtimePay = overtimePay;
        this.perHourPay = perHourPay;
        this.date = date;
    }

    public int getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getMedicalAllowance() {
        return medicalAllowance;
    }

    public void setMedicalAllowance(double medicalAllowance) {
        this.medicalAllowance = medicalAllowance;
    }

    public double getPerDayPay() {
        return perDayPay;
    }

    public void setPerDayPay(double perDayPay) {
        this.perDayPay = perDayPay;
    }

    public double getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(double totalPayable) {
        this.totalPayable = totalPayable;
    }

    public double getHouseRent() {
        return houseRent;
    }

    public void setHouseRent(double houseRent) {
        this.houseRent = houseRent;
    }

    public double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(double overtimePay) {
        this.overtimePay = overtimePay;
    }

    public double getPerHourPay() {
        return perHourPay;
    }

    public void setPerHourPay(double perHourPay) {
        this.perHourPay = perHourPay;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}
