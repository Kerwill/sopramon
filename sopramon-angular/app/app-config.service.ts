import { Injectable } from '@angular/core';


@Injectable()
export class AppConfigService{


private urlApi : string = "http://localhost:8080/api/";
// private apiUser: string = "frofro44";
// private apiPassword: string = "123456";

public getUrlApi(){
  return this.urlApi;
}

// public getApiBasic(): string {
//         return 'Basic ' + btoa(this.apiUser + ':' + this.apiPassword);
//     }

 }
