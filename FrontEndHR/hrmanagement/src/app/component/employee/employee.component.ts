import { Component } from '@angular/core';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent {

  constructor(public employeeService : EmployeeService){

  }

  ngOnInit(){
     this.employeeService.getEmployees()
  }

}
