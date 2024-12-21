package com.hrmanagementsystem.entity;

import java.sql.Date;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class EmployeeDTO {
    int employeeId;
    String employeeName;
    double salary;
    Date joiningDate;
    String email;
    String password;

    private DepartmentDTO department;


    public EmployeeDTO() {

    }

    public EmployeeDTO(int employeeId, String employeeName, double salary, Date joiningDate, String email,String password,
                    DepartmentDTO department) {
        super();
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.email = email;
        this.password = password;
        this.department = department;
    }

    public EmployeeDTO(int employeeId, String employeeName, double salary, String email, String password, DepartmentDTO departmentDTO) {
    }


    public int getEmployeeId() {
        return employeeId;
    }


    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    public String getEmployeeName() {
        return employeeName;
    }


    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


    public double getSalary() {
        return salary;
    }


    public void setSalary(double salary) { this.salary = salary; }


    public Date getJoiningDate() {
        return joiningDate;
    }


    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {this.password = password;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }


    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", Salary=" + salary
                + ", joiningDate=" + joiningDate + ", email=" + email + ", password=" + password + ", department=" + department + "]";
    }


}