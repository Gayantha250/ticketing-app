import {Component, OnInit} from '@angular/core';
import {BillService} from "../../../service/bill.service";
import {Bill} from "../../../DTO/ResponseCheckInBillDTO";

@Component({
  selector: 'app-billpop',
  templateUrl: './billpop.component.html',
  styleUrls: ['./billpop.component.scss']
})
export class BillpopComponent implements OnInit {
  allDetails=this.billService.billDetails;
  categorye: String = "";
  checkOutTime: String = "";
  date: String = "";
  hourly_Rate: String = "";
  regNumber: String = "";
  time: String = "";
  total_cost: String = "";
  constructor(public billService: BillService) {
    this.addAllDetails();
  }
  ngOnInit(): void {
    if (this.billService.billDetails.length > 0){
      this.categorye=this.allDetails[0].category;
      this.date = this.allDetails[0].date;
      this.checkOutTime=this.allDetails[0].checkOutTime;
      this.hourly_Rate=this.allDetails[0].hourly_Rate;
      this.regNumber=this.allDetails[0].regNumber;
      this.time=this.allDetails[0].time;
      this.total_cost=this.allDetails[0].total_cost;
    }
  }
  addAllDetails() {
    console.log("AddAllDetails");
    if (this.billService.billDetails.length > 0) {
      console.log("inside the if");
      this.allDetails[0] = this.billService.billDetails[0];
      console.log(this.allDetails)
    }
  }
}
