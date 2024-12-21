import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {
  
  employees:Employee[]
  employeeUpdated:boolean
  
  constructor(public http:HttpClient) {
    this.employees=[],this.employeeUpdated=false
   }

  updateEmployee(employee:Employee)
  {
    this.employeeUpdated=false
    this.http.post<Employee>    
      ('http://localhost:8080/employees',employee).subscribe(data=> 
        {this.employeeUpdated=true}
    )
  }
}
