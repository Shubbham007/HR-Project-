package com.hrmanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.hrmanagementsystem.entity.DepartmentDTO;
import com.hrmanagementsystem.entity.EmployeeDTO;
import com.hrmanagementsystem.exception.DepartmentNotFound;
import com.hrmanagementsystem.exception.EmployeeNotFound;
import com.hrmanagementsystem.projectiondto.DeparmentProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hrmanagementsystem.entity.Department;
import com.hrmanagementsystem.entity.Employee;
import com.hrmanagementsystem.repository.DepartmentRepository;


import jakarta.transaction.Transactional;

@RestController
@Transactional
@CrossOrigin
public class DepartmentController {
	@ExceptionHandler(DepartmentNotFound.class)
	public ResponseEntity<String> HandlerEmployeeNotFound(DepartmentNotFound employeeNotFound){

		return new ResponseEntity<String>("Department not found.", HttpStatus.NOT_FOUND);
	}


	@Autowired
	DepartmentRepository departmentRepository;
	
//	@GetMapping("departments")
//	public List<DepartmentDTO>getDepartments(){
//		List<DepartmentDTO> departmentDTOS = new ArrayList<>();
//		List<Department> realDepartment =(List<Department>)departmentRepository.findAll();
//		for(Department dept : realDepartment){
//			List<EmployeeDTO> employeeDTOS= new ArrayList<>();//null
//			List <Employee> realEmployee = dept.getEmployee();
//
//			for(Employee emp : realEmployee){
//				EmployeeDTO emplpoyeeDTO = new EmployeeDTO(emp.getEmployeeId(),emp.getEmployeeName(),emp.getSalary(),emp.getJoiningDate(),emp.getEmail(),emp.getPassword(),null);
//				employeeDTOS.add(emplpoyeeDTO);
//			}
//			DepartmentDTO departmentDTO = new DepartmentDTO(dept.getDepartmentId(),dept.getDepartmentName(),employeeDTOS);
//			departmentDTOS.add(departmentDTO);
//		}
//		return departmentDTOS;
//	}
	@GetMapping("department/{departmentId}")
    public DeparmentProjection getDepartmentByDepartmentId(@PathVariable int departmentId){
	return (DeparmentProjection) departmentRepository.findByDepartmentId(departmentId);
	}

	@GetMapping("department")
	public List<DeparmentProjection>getDepartments(){
		return (List<DeparmentProjection>)departmentRepository.findBy();
	}

	@GetMapping("department/find/{departmentName}")
	public List<DeparmentProjection> getDepartmentByDepartmentName(@PathVariable String departmentName){
		return (List<DeparmentProjection>) departmentRepository.findByDepartmentName(departmentName);
	}


	@PostMapping("departments")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentRepository.save(department);
	}
	
	@DeleteMapping("departments/{departmentId}")
	public String deleteDepartment(@PathVariable int departmentId) {
		Integer res = departmentRepository.deleteByDepartmentId(departmentId);
		if(res == 1)
			return "Department deleted successfully";
		throw new DepartmentNotFound();
	}

}
