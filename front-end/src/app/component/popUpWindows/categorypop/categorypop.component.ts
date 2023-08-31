import {Component, Inject, OnInit} from '@angular/core';
import {AreaService} from "../../../service/area.service";
import {CategoryService} from "../../../service/category.service";
import {NgForm} from "@angular/forms";



export interface DialogData {

}
@Component({
  selector: 'app-categorypop',
  templateUrl: './categorypop.component.html',
  styleUrls: ['./categorypop.component.scss']
})
export class CategorypopComponent implements OnInit{
  categoryValue:String="";
  hourly_rate:String="";
  constructor(public categoryService:CategoryService){
  }
  submitCategory(categoryForm: NgForm) {
    this.categoryService.saveCategory(categoryForm.value).subscribe((response:any)=>{
      window.location.reload();
    },
      error => {
        console.log(error);
      }
    )
  }
  ngOnInit(): void {
   this.categoryValue=this.categoryService.categoryValue;
   this.hourly_rate=this.categoryService.hourly_rateValue;
  }
  submitUpdatedCategory(categoryUpdateForm: NgForm) {
    this.categoryService.updateCategory(categoryUpdateForm.value).subscribe((response:any)=>{
      window.location.reload();
    })
  }
}
