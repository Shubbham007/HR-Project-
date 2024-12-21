package com.hrmanagementsystem.entity;


import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;


//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Department {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int departmentId;
String departmentName;


@OneToMany(mappedBy="department")
private List<Employee> employee;


public Department() {

}


public Department(int departmentId, String departmentName, List<Employee> employee) {
	super();
	this.departmentId = departmentId;
	this.departmentName = departmentName;
	this.employee = employee;
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


public List<Employee> getEmployee() {
	return employee;
}


public void setEmployee(List<Employee> employee) {
	this.employee = employee;
}


@Override
public String toString() {
	return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employee=" + employee
			+ "]";
}



}
