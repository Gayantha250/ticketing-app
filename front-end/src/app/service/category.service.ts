import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient:HttpClient) { }

  getCategory(){
   return  this.httpClient.get('http://localhost:8080/api/v1/rate');
  }
}
