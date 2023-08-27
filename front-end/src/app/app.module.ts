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
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {MatButtonModule} from "@angular/material/button";
import {MatDialogModule} from "@angular/material/dialog";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import {CategorypopComponent} from "./component/popUpWindows/categorypop/categorypop.component";
import { ParkingAreapopComponent } from './component/popUpWindows/parking-areapop/parking-areapop.component';
import { CheckInpopComponent } from './component/popUpWindows/check-inpop/check-inpop.component';
import {MatSelectModule} from "@angular/material/select";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatTableModule} from "@angular/material/table";
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {InterceptorService} from "./service/interceptor.service";
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CheckInComponent,
    ListComponent,
    CategoryComponent,
    ParkingAreaComponent,
    ForbiddenComponent,
    ParkingAreapopComponent,
    CheckInpopComponent,
    CategorypopComponent
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
        MatSelectModule,
        MatDatepickerModule,
        MatNativeDateModule,
        HttpClientModule,
        MatTableModule,
      MatProgressBarModule
    ],
  providers: [
    {provide:HTTP_INTERCEPTORS,useClass:InterceptorService,multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
