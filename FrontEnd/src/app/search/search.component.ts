import { Component, OnInit,Input,Output } from '@angular/core';
import{EmployeeService} from 'src/app/employee.service';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})

export class SearchComponent implements OnInit {
  @Input() data:any;
  sorteddata:any=[];
  searchedKeyword!: string;
  filterTerm!: string;
  emptyResultText!:string;

  userRecords = [
  ]
  
  
  constructor( private Employeeservice:EmployeeService) { }

  ngOnInit(): void {
  }
  onSubmit(data: { searchByValue: string;searchOnValue: string; searchValue: string}) {
    //console.log(data);
    if(data.searchByValue=="" ||data.searchOnValue=="" ||data.searchValue==""){
      alert("Invaild Search Inputs.\n Search By, Search Option And Search Value Can't Be Empty!");
      return;
    }
   this.Employeeservice.searchEmployee(data).subscribe((searchResult)=>{
    this.sorteddata=searchResult;
    console.log(this.sorteddata);
    if(this.sorteddata.length ==0){
      this.emptyResultText="No Search Result Found For Given Input Value!"
    }else{
      this.emptyResultText="";
    }
    
    })
   
    
  }
  

}
