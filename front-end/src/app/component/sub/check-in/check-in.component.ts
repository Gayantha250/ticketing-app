import {AfterViewInit, Component, OnInit, Output} from '@angular/core';
import {CheckInpopComponent} from "../../popUpWindows/check-inpop/check-inpop.component";
import {MatDialog} from "@angular/material/dialog";
import {CategorypopComponent} from "../../popUpWindows/categorypop/categorypop.component";
import {CheckInService} from "../../../service/check-in.service";
import {CheckIn} from "../../../DTO/ResponseCheckInDTO";
import { ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-check-in',
  templateUrl: './check-in.component.html',
  styleUrls: ['./check-in.component.scss']
})
export class CheckInComponent implements OnInit{
  checkInDetails: Array<CheckIn> = [];
  tabKey: any = [];
  tabValue: any = [];
  constructor(private matDialog: MatDialog, public checkInService: CheckInService) {
  }

  openDialog() {
    this.matDialog.open(CheckInpopComponent, {
      width: '340xp',
    });
  }

  getAllDetails() {
    this.checkInService.getAllCheckIns(0, 5).subscribe((response: any) => {
      this.checkInDetails = response.data.list as Array<CheckIn>
      this.checkInDetails.forEach((elements: any) => {
        this.tabKey = Object.keys(elements);
        this.tabValue.push(Object.values(elements));
      })
    },
      error => {
        console.log(error);
      }
      )
  }
  ngOnInit(): void {
    this.getAllDetails();
  }
  deleteRow(tabValueElement: any) {
    this.checkInService.deleteCheckIns(tabValueElement[0]).subscribe((response:any)=>{
     window.location.reload();
    });
  }
}
