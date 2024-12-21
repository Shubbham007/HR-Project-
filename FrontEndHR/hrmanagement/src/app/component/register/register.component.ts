import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Department } from 'src/app/model/department';
import { Employee } from 'src/app/model/employee';
import { DepartmentService } from 'src/app/service/department.service';
import { EmployeeService } from 'src/app/service/employee.service';
import { RegisterService } from 'src/app/service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
departments : Department 
employees : Employee
  constructor(public route:ActivatedRoute, public employeeService: EmployeeService,public departmentService: DepartmentService,public registerService :RegisterService) {
    this.departments=new Department;
    this.employees=new Employee;
    
  }
  ngOnInit()
  {
    this.departmentService.getDepartments();
  }
  
  registerEmployee(employee:Employee){
    this.registerService.postEmployee(employee);
}
}
