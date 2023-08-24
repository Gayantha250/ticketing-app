import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {AreaService} from "../../../service/area.service";




@Component({
  selector: 'app-parking-areapop',
  templateUrl: './parking-areapop.component.html',
  styleUrls: ['./parking-areapop.component.scss']
})
export class ParkingAreapopComponent implements OnInit {

  constructor(public areaService: AreaService) {
  }
  ngOnInit(): void {
    console.log("on inot woring");

  }
  area(areaForm: NgForm) {
    const newCapacity = areaForm.value.capacity;
    areaForm.value.capacity = parseInt(newCapacity, 10);
    this.areaService.saveArea(areaForm.value).subscribe(
      (response) => {
        // console.log(response);
      },
      (error => {
        console.log(error);
      })
    )
  }

}
