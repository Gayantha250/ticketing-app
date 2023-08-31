
import {LoaderService} from "./service/loader.service";
import { Component, NgZone } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(public loadService:LoaderService,private ngZone: NgZone) {
  }
  title = 'front-end';
  opened=false;
  toggleMenu() {
    this.ngZone.run(() => {
      setTimeout(() => {
        this.opened = !this.opened;
      }, 0);
    });
  }

}
