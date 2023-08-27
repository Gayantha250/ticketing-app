import {Component, OnInit} from '@angular/core';
import {CategorypopComponent} from "../../popUpWindows/categorypop/categorypop.component";
import {MatDialog} from "@angular/material/dialog";
import {ParkingAreapopComponent} from "../../popUpWindows/parking-areapop/parking-areapop.component";
import {AreaService} from "../../../service/area.service";
import {SavedArea} from "../../../DTO/ResponseSavedAreaDTO";
import {elementAt} from "rxjs";

@Component({
  selector: 'app-parking-area',
  templateUrl: './parking-area.component.html',
  styleUrls: ['./parking-area.component.scss']
})
export class ParkingAreaComponent implements OnInit{
 savedAreas:Array<SavedArea>=[];
 updateAreaValues=this.areaService.savedAreas;
 tabKey:any=[];
 tabValue:any=[];
constructor(private matDialog:MatDialog,public areaService:AreaService) {
}
    openDialog() {
    this.matDialog.open(ParkingAreapopComponent,{
      width:'340xp',
    })
  }
  getAllAreas(){
    this.areaService.getArea().subscribe((response: any) => {
        this.savedAreas = response.data as Array<SavedArea>;
        console.log(this.updateAreaValues.length);
        this.savedAreas.forEach(element => {
          this.tabKey = Object.keys(element);
          this.tabValue.push(Object.values(element));
    });
 },
   error => {
     console.log(error);
   }
   )
  }
  ngOnInit(): void {
  this.getAllAreas();
  }

  deleteArea(tabValueElement: any) {
    const id = parseInt(tabValueElement[0], 10)
    this.areaService.delete(id).subscribe(response=>{
      window.location.reload();
    })
  }
}
