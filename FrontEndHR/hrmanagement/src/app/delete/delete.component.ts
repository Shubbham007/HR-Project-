import { Component } from '@angular/core';
import { DeleteService } from '../service/delete.service';
import { Employee } from '../model/employee';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent {

  employee:Employee
  constructor(public deleteService:DeleteService)
  {
    this.employee=new Employee()
  }

  selectEmployeeId()
   {
    for(let i=0;i<this.deleteService.employees.length;i++)
    
      if(this.deleteService.employees[i].employeeId==this.employee.employeeId)
        Object.assign(this.employee ,this.deleteService.employees[i])
   }
   deleteSubmit(deleteForm:any)
   {
     this.deleteService.deleteEmployee(this.employee.employeeId)

     setTimeout(() => {
      this.deleteService.employeeDeleted = false; // Hide success message
      window.location.reload(); // Reload page
    }, 6000); // 6 seconds
   }

}
