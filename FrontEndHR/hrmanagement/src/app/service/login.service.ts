import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  loginSuccessfull : boolean

  constructor(public http:HttpClient) { this.loginSuccessfull=false}

loginSuccess(user: User) 
  {
  this.loginSuccessfull = false;

  this.http.post<Employee>('http://localhost:8080/employee/login', user).subscribe(
    data => {
      if (data) 
        {
        // Login successful
        this.loginSuccessfull = true;
        alert("Login Successful");
      }
    },
    error => 
      {
      // Handle error (404 error for incorrect credentials)
      if (error.status == 404) {
        alert("Invalid email or password. Please try again.");
      }
    }
  );
}
}