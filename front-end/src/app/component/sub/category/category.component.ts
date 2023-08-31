import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../../service/category.service";
import {MatDialog} from "@angular/material/dialog";
import {CategorypopComponent} from "../../popUpWindows/categorypop/categorypop.component";
import {GetCategory} from "../../../DTO/ResponseCategoryDTO";


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss'],

})
export class CategoryComponent implements OnInit{
  categoryDetails:Array<GetCategory>=[];
  bindingValues:any=[];
  tabKey:any=[];
  tabValue:any=[];
  constructor(public categoryService:CategoryService,private matDialog:MatDialog){}
  ngOnInit(): void {
    this.getCategory();
  }
  openDialog() {
    this.matDialog.open(CategorypopComponent,{
      width:'340xp',
    })
     this.bindingValues=[];
  }
  getCategory(){
    this.categoryService.getCategory().subscribe(
      (response:any)=>{
       this.categoryDetails   =response.data as Array<GetCategory>;
       this.categoryDetails.forEach((element:any)=>{
         this.tabKey = Object.keys(element);
         this.tabValue.push(Object.values(element));
       })
      },
      error => {
        console.log(error);
      }
    )
  }
  bindValues(tabValueElement: any) {
      this.bindingValues.push(tabValueElement[0],tabValueElement[1],tabValueElement[2]);
      this.categoryService.bindingAllValues(this.bindingValues);
  }

  deleteCat(tabValueElement: any) {
    console.log(tabValueElement[0]);
    this.categoryService.deleteCategory(tabValueElement[0]).subscribe((response:any)=>{
      window.location.reload();
    })
  }
}
