import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../../service/category.service";
import {MatDialog} from "@angular/material/dialog";
import {CategorypopComponent} from "../../popUpWindows/categorypop/categorypop.component";


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss'],

})
export class CategoryComponent implements OnInit{

  constructor(public categoryService:CategoryService,private matDialog:MatDialog){}
  ngOnInit(): void {
    this.categoryService.getCategory().subscribe(data=>{

    });


  }
  openDialog() {
    this.matDialog.open(CategorypopComponent,{
      width:'350xp',

    })



  }
}
