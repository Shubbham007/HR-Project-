import { Employee } from "./employee";

export class Department{

    departmentId: number
    departmentName: string
    employees: Employee[];

    constructor()   
{
 this.departmentId=0;
 this.departmentName=''
 this.employees=[]
}

}