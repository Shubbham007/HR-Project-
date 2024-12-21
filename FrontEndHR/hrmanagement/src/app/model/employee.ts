import { Department } from "./department";

export class Employee{

employeeId: number;
employeeName: String | null;
salary: number | null;
joiningDate: Date | null;
email: String | null;
password: String | null;
department: Department;

constructor(){
    this.employeeId=0;
    this.employeeName='';
    this.salary=0;
    this.joiningDate=new Date(0,0,0);
    this.email='';
    this.password='';
    this.department=new Department();
}
}