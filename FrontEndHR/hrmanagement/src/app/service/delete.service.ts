import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class DeleteService {
  employees : Employee[]
  employeeDeleted : boolean
  constructor(public http:HttpClient) {
  this.employees=[]
    this.employeeDeleted=false
  }
   
  deleteEmployee(employeeId:number)
  {
    this.employeeDeleted=false
    this.http.delete<any>('http://localhost:8080/employees/'+employeeId).subscribe(data=>
     { if(data.status)
    this.employeeDeleted=true}
    )
  }
}
