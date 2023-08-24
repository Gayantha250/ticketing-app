import {Component, OnInit} from '@angular/core';
import {HomeService} from "../../../service/home.service";
import {Area} from "../../../DTO/ResponseAreaDTO";
import {elementAt} from "rxjs";
import {MatDialog} from "@angular/material/dialog";
import {CheckInpopComponent} from "../../popUpWindows/check-inpop/check-inpop.component";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{
  constructor(public homeService:HomeService) {}

   areas: Array<Area>=[];

  tabKey:any=[];
  tabValue:any=[];
  ngOnInit(): void {
    this.getData();
  }
  getData() {
    this.homeService.getDatas().subscribe(
      (response:any) => {
        this.areas=response.data as Array<Area>;
      this.areas.forEach(element=>{
        this.tabKey=Object.keys(element);
        this.tabValue.push(Object.values(element));
      })


      },
      (error) => {
        console.log(error);
      }
    )
  }


}
