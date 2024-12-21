package com.hrmanagementsystem.projectiondto;

import com.hrmanagementsystem.entity.Employee;

import java.util.List;

public interface DeparmentProjection {


    public Integer getDepartmentId();
    public String getDepartmentName();
    public List<Employee> getEmployee();

    public interface Employee {
        public Integer getEmployeeId();
        public String getEmployeeName();


    }

}
