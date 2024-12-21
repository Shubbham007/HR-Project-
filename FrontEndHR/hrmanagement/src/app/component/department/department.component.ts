import { Component } from '@angular/core';
import { DepartmentService } from 'src/app/service/department.service';


@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent {
  constructor(public departmentService: DepartmentService)
{

}
ngOnInit(){
  this.departmentService.getDepartments()
}
}
