import { Injectable } from '@angular/core';
import { Department } from '../model/department';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  departments: Department[];

  constructor(public http:HttpClient) {

    this.departments= [];
  }

  getDepartments()
  {
    return this.http.get<Department[]>('http://localhost:8080/department').subscribe(data => { this.departments = data; })
  }
   
}
