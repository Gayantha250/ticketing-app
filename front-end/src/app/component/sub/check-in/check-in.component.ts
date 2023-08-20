import {Component, OnInit} from '@angular/core';
import {CheckInpopComponent} from "../../popUpWindows/check-inpop/check-inpop.component";
import {MatDialog} from "@angular/material/dialog";
import {CategorypopComponent} from "../../popUpWindows/categorypop/categorypop.component";

@Component({
  selector: 'app-check-in',
  templateUrl: './check-in.component.html',
  styleUrls: ['./check-in.component.scss']
})
export class CheckInComponent implements OnInit{

  constructor(private matDialog:MatDialog) {
  }
  openDialog() {
    this.matDialog.open(CheckInpopComponent, {
      width: '340xp',
    });

  }

  ngOnInit(): void {
  }
}
