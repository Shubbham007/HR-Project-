import { Injectable } from '@angular/core';
import { Department } from '../model/department';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  departments:Department[];
  employees:Employee[];

  

  constructor(public http:HttpClient) {
    this.departments=[]
    this.employees=[]
 
   }

   getDepartments(){
    this.http.get<Department[]>('http://localhost:8080/department').subscribe(data => { this.departments = data; })

   }
   postDepartment(department : Department){
    this.http.post<Department>('http://localhost:8080/departments',department).subscribe(data=>{this.departments.push(data)})
   }
   postEmployee(employee : Employee){
    this.http.post<Employee>('http://localhost:8080/employees',employee).subscribe(data=>{this.employees.push(data)})
   }

}