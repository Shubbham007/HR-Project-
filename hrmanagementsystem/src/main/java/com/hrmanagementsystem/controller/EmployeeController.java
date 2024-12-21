package com.hrmanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;


import com.hrmanagementsystem.entity.Department;
import com.hrmanagementsystem.entity.DepartmentDTO;
import com.hrmanagementsystem.entity.EmployeeDTO;
import com.hrmanagementsystem.exception.EmployeeNotFound;
import com.hrmanagementsystem.projectiondto.EmployeeProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hrmanagementsystem.entity.Employee;
import com.hrmanagementsystem.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@Transactional
@CrossOrigin
public class EmployeeController{

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<String> HandlerEmployeeNotFound(EmployeeNotFound employeeNotFound){

        return new ResponseEntity<String>("Employee not found.", HttpStatus.NOT_FOUND);
    }


    @Autowired
    EmployeeRepository employeeRepository;


//    @GetMapping("employees")// to resolve the null exception we use this method
//    public List<EmployeeDTO> getEmployees(){
//        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
//        List<Employee> realEmployees= (List<Employee>) employeeRepository.findAll();
//        for(Employee emp:realEmployees){
//            DepartmentDTO departmentDTO= null;
//            Department realDepartment = emp.getDepartment();
//            for(int i=0;i<realEmployees.size();i++)
//            {
//                departmentDTO = new DepartmentDTO(realDepartment.getDepartmentId(), realDepartment.getDepartmentName(),null);
//                Department dept = emp.getDepartment();
//                dept.setEmployee(null);
//            }
//            EmployeeDTO employeeDTO = new EmployeeDTO(emp.getEmployeeId(),emp.getEmployeeName(),emp.getSalary(),emp.getJoiningDate(),emp.getEmail(),emp.getPassword(),departmentDTO);
//            employeeDTOS.add(employeeDTO);
//        }
//        return employeeDTOS;
//    }

    @GetMapping("employee/{employeeId}")
    public EmployeeProjection getEmployeeByEmployeeId(@PathVariable int employeeId){
        return (EmployeeProjection) employeeRepository.findByEmployeeId(employeeId);
    }

    @GetMapping("employee")
    public List<EmployeeProjection>getEmployees(){
        return (List<EmployeeProjection>)employeeRepository.findBy();
    }
    @GetMapping("employee/find/name/{employeeName}")
    public List<EmployeeProjection> getEmployeeByEmployeeName(@PathVariable String employeeName){
        return (List<EmployeeProjection>) employeeRepository.findByEmployeeName(employeeName);
    }

    @PostMapping("employees")
    public Employee saveEmployees(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


    @PostMapping("employee/login")
    public EmployeeProjection getEmployeeLogin(@RequestBody Employee employee) {

        EmployeeProjection emp = employeeRepository.findByEmailAndPassword(employee.getEmail(),employee.getPassword());
        if(emp != null){
            return emp;
        }
        else {

        }
        return null;
    }


    @DeleteMapping("employees/{employeeid}")
    public String deleteEmployee(@PathVariable int employeeid){

        int result = employeeRepository.deleteByEmployeeId(employeeid);
        if(result==1)
        {
            return "OK";
        }
        else
            throw new EmployeeNotFound();
    }

    //TODO:Update employee by Id
    @PostMapping("employees/{employeeId}")
    public EmployeeDTO updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee employee)
    {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElse(null);

        if (existingEmployee != null) {
            // Update the existing employee's details with the new data
            existingEmployee.setEmployeeName(employee.getEmployeeName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setJoiningDate(employee.getJoiningDate());
            existingEmployee.setPassword(employee.getPassword());
            existingEmployee.setDepartment(employee.getDepartment());

            Employee updatedEmployee = employeeRepository.save(existingEmployee);
            EmployeeDTO employeeDTO = new EmployeeDTO(updatedEmployee.getEmployeeId(), updatedEmployee.getEmployeeName(),
                    updatedEmployee.getSalary(),updatedEmployee.getJoiningDate(), updatedEmployee.getEmail(), updatedEmployee.getPassword(),
                    new DepartmentDTO(updatedEmployee.getDepartment().getDepartmentId()));
            return employeeDTO;
        }

        return null;
    }

}
