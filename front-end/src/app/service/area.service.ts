import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SavedArea} from "../DTO/ResponseSavedAreaDTO";
import {UpdateArea} from "../DTO/ResponseUpdateAreaDTO";


@Injectable({
  providedIn: 'root'
})
export class AreaService {
  BASE_URL = "http://localhost:8080";
  updateArea: Array<UpdateArea> = [];
  public idVal: number = 0;
  savedAreas: Array<SavedArea> = [];
  constructor(private httpClient: HttpClient) {
  }
  public saveArea(areaData: any) {
    return this.httpClient.post(this.BASE_URL + "/api/v1/area/savearea", areaData);
  }
  public getArea() {
    return this.httpClient.get(this.BASE_URL + "/api/v1/area/getAreaCapacity");
  }
  public update(areaUpdateFormData: any) {
    return this.httpClient.patch(this.BASE_URL + `/api/v1/area/updatecapacity/${this.idVal}`, areaUpdateFormData);
  }
  showSave = false;
  showUpdate = false;
  public showSavedAreas() {
    this.showUpdate = false;
    return this.showSave = !this.showUpdate;
  }
  public showUpdateAreas() {
    this.showSave = false;
    return this.showUpdate = !this.showSave;
  }
  public updatedId(arrayValue: any) {
    this.idVal = arrayValue[0];
    this.updateArea.push(arrayValue[1], arrayValue[2]);
  }

  // addUpdatedData(data:any){
  //   console.log("addUpdate-1");
  //     if(data.id===this.idVal){
  //       this.savedAreas.push(data.id,data.area,data.capacity);
  //     }
  // }
}
