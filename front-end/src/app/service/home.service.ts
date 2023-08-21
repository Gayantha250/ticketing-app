import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  BASE_URL="http://localhost:8080";
  constructor(private httpClient:HttpClient) { }

  public getDatas(){
    return this.httpClient.get(this.BASE_URL+"/api/v1/area/getall");
  }
}
