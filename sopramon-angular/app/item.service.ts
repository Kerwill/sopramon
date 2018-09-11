import { Injectable } from '@angular/core';
import { Item } from './item';
/*import { Http, Headers, RequestOptions } from '@angular/http';*/
import { Http } from '@angular/http';
import { AppConfigService } from './app-config.service';



@Injectable()
export class ItemService{

private items: Array<Item> = new Array<Item>();
/*private myOptions: RequestOptions;*/

constructor( private http: Http, private apiConfigService : AppConfigService) {
/*let myHeaders: Headers = new Headers();
myHeaders.append('Authorization', this.apiConfigService.getApiBasic());
this.myOptions = new RequestOptions({ headers: myHeaders });
*/
      this.http
           .get(this.apiConfigService.getUrlApi() + "items"/*, this.myOptions*/)
           .subscribe(resp => {
               for (let i of resp.json()._embedded.items) {
                   this.items.push(new Item(i));
               }
           });
}

public findAll() : Array<Item>{
  return this.items;
}

/*
public findAllByNom(nom: string) : Array<Item> {

  return this.produits.filter(i =>
      i.getNom()
          .toLowerCase()
          .indexOf(nom.toLowerCase()) !== -1
  )
}
*/
}
