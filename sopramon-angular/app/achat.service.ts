import { Injectable } from '@angular/core';
import { Achat } from './achat';
/*import { Http, Headers, RequestOptions } from '@angular/http';*/
import { Http } from '@angular/http';
import { AppConfigService } from './app-config.service';



@Injectable()
export class AchatService{

private achats: Array<Achat> = new Array<Achat>();
/*private myOptions: RequestOptions;*/

constructor( private http: Http, private appConfigService : AppConfigService) {
/*let myHeaders: Headers = new Headers();
myHeaders.append('Authorization', this.apiConfigService.getApiBasic());
this.myOptions = new RequestOptions({ headers: myHeaders });
*/
      
}

public findAll() : Array<Achat>{
  return this.achats;
}

public add(item) {


  let achat = {sopramon : this.appConfigService.getUrlApi()+"sopramons/34", item : item.getHref(), prix : item.getPrix()}

this.http
.post(this.appConfigService.getUrlApi()+"achats", achat/*, this.myOptions*/)
.subscribe(resp => this.achats.push(achat), err => alert(err));
}

}
