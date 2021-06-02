import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  url:string ='http://localhost:8001/employee/post/';
  url1:string ='http://localhost:8001/employee/All/';
  searchUrl:string="http://localhost:8001/employee";
  constructor(private http:HttpClient) { }
  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }
  postEmployeedetail(data : any){ 
    console.log(data);
    return this.http.post(this.url, data);
  }
  getEmployeedetail(){ 
    return this.http.get(this.url1);
  }

  searchEmployee( data:any){
   
    console.log(this.searchUrl);
    console.log(data);
    return this.http.get(this.searchUrl +"/"+data.searchBy+"/"+data.searchOn+"/"+data.searchValue);
  }
}


