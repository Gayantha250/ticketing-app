import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Bill} from "../DTO/ResponseCheckInBillDTO";

@Injectable({
  providedIn: 'root'
})
export class BillService {

  billDetails:Array<Bill>=[];
  BASE_URL = "http://localhost:8080";
  constructor(public httpClient:HttpClient) { }

  getAllBillData(tabValueElementElement: any){
    return this.httpClient.get(this.BASE_URL+`/api/v1/checkin/getrow/${tabValueElementElement}`);
  }
  billData(data:any){
  this.billDetails[0]=data;
  }
}
