package com.hrmanagementsystem.projectiondto;

import com.hrmanagementsystem.entity.Department;

import java.sql.Date;

public interface EmployeeProjection {


    public Integer getEmployeeId();
    public String getEmployeeName();
    public double getSalary();
    public Date getJoiningDate();
    public String getEmail();
    public String getPassword();
    public Department getDepartment();

    public interface Department{
    public Integer getDepartmentId();
    public String getDepartmentName();
}
}
