import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CheckInService {
  BASE_URL = "http://localhost:8080";
  constructor(public httpClient:HttpClient) { }

  saveAllCheckIn(value: any){
    return  this.httpClient.post(this.BASE_URL+"/api/v1/checkin/saveall",value);
  }
  getAllCheckIns(page:any, size:any){
    return this.httpClient.get(this.BASE_URL+`/api/v1/checkin/getall?page=${page}&size=${size}`);
  }

  deleteCheckIns(tabValueElementElement: any){
    return this.httpClient.delete(this.BASE_URL+`/api/v1/checkin/delete/${tabValueElementElement}`);
  }

}
