import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {CheckInService} from "../../../service/check-in.service";

@Component({
  selector: 'app-check-inpop',
  templateUrl: './check-inpop.component.html',
  styleUrls: ['./check-inpop.component.scss']
})
export class CheckInpopComponent implements OnInit{

  constructor(public checkInService:CheckInService) {
  }
  ngOnInit(): void {
  }
  saveCheckIn(inputCheckIns: NgForm) {
  this.checkInService.saveAllCheckIn(inputCheckIns.value).subscribe((response:any)=>{
   window.location.reload();
  })
  }
}
