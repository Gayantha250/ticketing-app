import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NgForm} from "@angular/forms";


@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  id:number=0;
  categoryValue:String= '';
  hourly_rateValue:String='';
  BASE_URL = "http://localhost:8080";
  constructor(private httpClient:HttpClient) { }

  getCategory(){
   return  this.httpClient.get(this.BASE_URL+"/api/v1/rate/getrates");
  }

  saveCategory(categoryFormData:any){
    return this.httpClient.post(this.BASE_URL+"/api/v1/rate/saverate",categoryFormData);
  }

  updateCategory(value: any){
    return this.httpClient.patch(this.BASE_URL+`/api/v1/rate/updaterates/${this.id}`,value);
  }

  deleteCategory(tabValueElementElement: any){
    return this.httpClient.delete(this.BASE_URL+`/api/v1/rate/deleterates/${tabValueElementElement}`)
  }

  update=false;
  save=false;
  showUpdate() {
    this.update=true;
    if(this.save)
      this.save=!this.save;
  }
  showSave(){
    this.save=true;
    if (this.update)
  this.update=!this.update;
  }
  bindingAllValues(bindingValues: any) {
      this.id=bindingValues[0];
      this.categoryValue=bindingValues[1];
      this.hourly_rateValue=bindingValues[2];

  }
}
