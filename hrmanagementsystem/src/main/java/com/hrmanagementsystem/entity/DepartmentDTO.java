package com.hrmanagementsystem.entity;
import java.util.List;


public class DepartmentDTO {

    int departmentId;
    String departmentName;

  //  private List<EmployeeDTO> employee;
    public DepartmentDTO() {

    }


    public DepartmentDTO(int departmentId, String departmentName, List<EmployeeDTO> employees) {
        super();
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    //    this.employee = employee;
    }


    public int getDepartmentId() {
        return departmentId;
    }


    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


    public String getDepartmentName() {
        return departmentName;
    }


    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

//    public List<EmployeeDTO> getEmployee() {
//        return employee;
//   }
//
//    public void setEmployee(List<EmployeeDTO> employee) {
//        this.employee = employee;
//   }

//
//    @Override
//    public String toString() {
//        return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employee=" + employee
//                + "]";
//   }

    public DepartmentDTO(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
