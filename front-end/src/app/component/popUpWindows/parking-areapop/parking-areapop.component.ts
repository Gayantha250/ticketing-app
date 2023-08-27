import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {AreaService} from "../../../service/area.service";
import {error} from "@angular/compiler-cli/src/transformers/util";




@Component({
  selector: 'app-parking-areapop',
  templateUrl: './parking-areapop.component.html',
  styleUrls: ['./parking-areapop.component.scss']
})
export class ParkingAreapopComponent implements OnInit {


  constructor(public areaService: AreaService) {
  }
  updateAreaArray=this.areaService.updateArea;
  areaId=this.areaService.idVal;
  selectedArea: String = '';
  capacityValue: number = 0;
  ngOnInit(): void {
    //this.updateAreaArray = this.areaService.updateArea;
    this.bindValues();
     this.updateAreaArray.length=0;
  }
  area(areaForm: NgForm) {
    const newCapacity = areaForm.value.capacity;  // convert capacity in to number
    areaForm.value.capacity = parseInt(newCapacity, 10);
    this.areaService.saveArea(areaForm.value).subscribe(
      (response) => {
      window.location.reload();
      },
      (error => {
        console.log(error);
      })
    )
  }
  areaUpdate(areaFormUpdate: NgForm) {
    const updateCapacity = areaFormUpdate.value.capacity;
    areaFormUpdate.value.capacity = parseInt(updateCapacity, 10);
    this.areaService.update(areaFormUpdate.value).subscribe(
      (response:any)=>{
       // this.areaService.addUpdatedData(response.data);
        window.location.reload();
      },
      error=>{
        console.log(error);
      }
    );
  }
  bindValues(){
    if (this.updateAreaArray.length > 0) {
      this.selectedArea = this.updateAreaArray[0].toString();
      const capacityValue = this.updateAreaArray[1].toString();
      this.capacityValue = parseInt(capacityValue, 10);
    }
  }
}
