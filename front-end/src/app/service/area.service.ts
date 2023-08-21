import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";



@Injectable({
  providedIn: 'root'
})
export class AreaService {

BASE_URL="http://localhost:8080";
  constructor(private httpClient:HttpClient) { }

  public saveArea(areaData:any){
  return this.httpClient.post( this.BASE_URL+ "/api/v1/area/savearea",areaData);

  }

}
