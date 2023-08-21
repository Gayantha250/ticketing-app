import {Component, OnInit} from '@angular/core';
import {Area} from "../../popUpWindows/parking-areapop/parking-areapop.component";
import {AreaService} from "../../../service/area.service";
import {HomeService} from "../../../service/home.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{
  areas: Area[]=[];
constructor(public homeService:HomeService) {
}
  ngOnInit(): void {
    this.getData();
  }
  getData() {
    this.homeService.getDatas().subscribe(
      (response:any) => {
        console.log(response);
        if(response){
          this.areas=response as Area[];
          console.log(this.areas);
        }
      },
      (error) => {
        console.log(error);
      }
    )
  }
}
