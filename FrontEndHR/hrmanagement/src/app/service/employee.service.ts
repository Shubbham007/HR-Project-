import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  employees: Employee[];

  constructor(public http :HttpClient) {

    this.employees=[];
   }

   getEmployees(){

    return this.http.get<Employee[]>('http://localhost:8080/employee').subscribe(data => { this.employees = data; })
   }
}
