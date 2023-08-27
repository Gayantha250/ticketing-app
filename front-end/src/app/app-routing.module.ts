import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {CategoryComponent} from "./component/sub/category/category.component";
import {CheckInComponent} from "./component/sub/check-in/check-in.component";
import {HomeComponent} from "./component/sub/home/home.component";
import {ListComponent} from "./component/sub/list/list.component";
import {ParkingAreaComponent} from "./component/sub/parking-area/parking-area.component";

const routes:Routes=[

  {
    path:"category",component:CategoryComponent
  },
  {
    path:"check-in",component:CheckInComponent
  },
  {
    path:"home",component:HomeComponent
  },
  {
    path:"list",component:ListComponent
  },
  {
    path:"",component:HomeComponent
  },

  {
    path:"parking-area",component:ParkingAreaComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
