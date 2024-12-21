import { Component } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  user:User
  loginOk:boolean
  constructor(private loginService :LoginService)
  {
    this.user=new User();
    this.loginOk=false
  }
  loginSubmit(loginForm:any)
  {
    if (loginForm.valid) 
      {
      this.loginService.loginSuccess(this.user);

      }

    }
}

