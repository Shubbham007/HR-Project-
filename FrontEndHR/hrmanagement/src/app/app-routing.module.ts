import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { RegisterComponent } from './component/register/register.component';
import { DepartmentComponent } from './component/department/department.component';
import { EmployeeComponent } from './component/employee/employee.component';
import { DeleteComponent } from './delete/delete.component';
import { UpdateComponent } from './component/update/update.component';

const routes: Routes = [{
  path:'home',
  component:HomeComponent
},
{
  path:'login',
  component:LoginComponent
},
{
path:'navbar',
component:NavbarComponent
},
{
  path:'register',
  component:RegisterComponent
},
{
  path:'department',
  component:DepartmentComponent
},
{
  path:'employee',
  component:EmployeeComponent
},
{
  path:'delete',
  component:DeleteComponent
},
{
  path:'update',
  component:UpdateComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
