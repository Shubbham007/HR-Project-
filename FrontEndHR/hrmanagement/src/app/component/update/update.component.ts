import { Component } from '@angular/core';
import { Employee } from 'src/app/model/employee';
import { UpdateService } from 'src/app/service/update.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {

  employee:Employee
  
  constructor(public updateService:UpdateService) {
    this.employee=new Employee();
   }
   updateSubmit(updateForm:any)
   {
    this.updateService.updateEmployee(this.employee)
    setTimeout(() => {
      this.updateService.employeeUpdated = false; // Hide success message
      window.location.reload(); // Reload page
    }, 6000); // 6 seconds

   }
   selectEmployeeId()
   {
    for(let i=0;i<this.updateService.employees.length;i++)
    
      if(this.updateService.employees[i].employeeId==this.employee.employeeId)
        Object.assign(this.employee ,this.updateService.employees[i])
   }

}
