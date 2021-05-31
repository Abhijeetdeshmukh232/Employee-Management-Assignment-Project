import { Component, OnInit ,Input} from '@angular/core';
import{EmployeeService} from 'src/app/employee.service';
import { from } from 'rxjs';
@Component({
  selector: 'app-save-details',
  templateUrl: './save-details.component.html',
  styleUrls: ['./save-details.component.css']
})
export class SaveDetailsComponent implements OnInit {
  @Input() data:any;
  responseData:any=[];
  constructor( private Employeeservice:EmployeeService) { }

  ngOnInit(): void {
  }
  
  onSubmit(data: { firstName: string;lastName: string; email: string;phoneno:string;streetaddress1:string;streetaddressline2:string;city:string;state:string;country:string;postal:any}) {
   if(data.firstName==""||data.lastName==""||data.email==""||data.phoneno==""||(data.streetaddress1=="" && data.streetaddressline2=="")||data.city==""||data.postal==""||data.country==""||data.state==""){
     alert("Failed To Add Employee \n Required Mandatory Field Are Missing");
     return;
   }  this.Employeeservice.postEmployeedetail(data).subscribe(res=>{
     this.responseData=res;
     if(res!==null){
       alert("Employee Record Successfully Created For "+this.responseData.firstName+" With Employee ID "+this.responseData.id);
       
     }else{
       alert("Server Error");
     }
     window.location.reload();
   });
   
 }

}
