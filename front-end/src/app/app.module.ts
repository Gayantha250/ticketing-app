import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import {RouterModule, RouterOutlet} from "@angular/router";
import { HomeComponent } from './component/sub/home/home.component';
import { CheckInComponent } from './component/sub/check-in/check-in.component';
import { ListComponent } from './component/sub/list/list.component';
import { CategoryComponent } from './component/sub/category/category.component';
import { ParkingAreaComponent } from './component/sub/parking-area/parking-area.component';
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ForbiddenComponent } from './component/sub/forbidden/forbidden.component';
import {HttpClientModule} from "@angular/common/http";
import {MatButtonModule} from "@angular/material/button";
import {MatDialogModule} from "@angular/material/dialog";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import {CategorypopComponent} from "./component/popUpWindows/categorypop/categorypop.component";
import { ParkingAreapopComponent } from './component/popUpWindows/parking-areapop/parking-areapop.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CheckInComponent,
    ListComponent,
    CategoryComponent,
    ParkingAreaComponent,
    ForbiddenComponent,
    CategorypopComponent,
    ParkingAreapopComponent

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    RouterOutlet,
    MatIconModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    MatButtonModule,
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
