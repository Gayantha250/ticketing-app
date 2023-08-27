import { Injectable } from '@angular/core';
import {finalize, Observable} from "rxjs";
import {LoaderService} from "./loader.service";
import { switchMapTo } from 'rxjs/operators'
import { timer } from 'rxjs';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from "@angular/common/http"; // Import HttpRequest
@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor{

  constructor(public  loaderService:LoaderService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

      this.loaderService.isLoading.next(true);

    return timer(2000).pipe( // Adjust the time duration (in milliseconds)
      switchMapTo(next.handle(req)),
      finalize(() => {
          this.loaderService.isLoading.next(false);
          }
        )

      )
  }
}
