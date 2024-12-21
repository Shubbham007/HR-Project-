package com.hrmanagementsystem.repository;

import com.hrmanagementsystem.projectiondto.EmployeeProjection;
import org.springframework.data.repository.CrudRepository;


import com.hrmanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	Integer deleteByEmployeeId(Integer employeeId);
	List<EmployeeProjection> findBy();
	List<EmployeeProjection> findByEmployeeName(String employeeName);
	EmployeeProjection findByEmployeeId(Integer employeeId);
	EmployeeProjection findByEmailAndPassword(String Email,String Password);
	
}
