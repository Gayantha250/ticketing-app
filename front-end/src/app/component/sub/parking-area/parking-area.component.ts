import { Component } from '@angular/core';
import {CategorypopComponent} from "../../popUpWindows/categorypop/categorypop.component";
import {MatDialog} from "@angular/material/dialog";
import {ParkingAreapopComponent} from "../../popUpWindows/parking-areapop/parking-areapop.component";

@Component({
  selector: 'app-parking-area',
  templateUrl: './parking-area.component.html',
  styleUrls: ['./parking-area.component.scss']
})
export class ParkingAreaComponent {
constructor(private matDialog:MatDialog) {
}
  openDialog() {
    this.matDialog.open(ParkingAreapopComponent,{
      width:'340xp',

    })
  }
}
