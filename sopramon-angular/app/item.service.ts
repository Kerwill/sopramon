import { Injectable } from '@angular/core';
import { Item } from './item';
/*import { Http, Headers, RequestOptions } from '@angular/http';*/
import { AppConfigService } from './app-config.service';



@Injectable()
export class ProduitService{


private produits: Array<Produit> = new Array<Produit>();
/*private myOptions: RequestOptions;*/


constructor(private http: Http, private apiConfigService : AppConfigService) {
let myHeaders: Headers = new Headers();
myHeaders.append('Authorization', this.apiConfigService.getApiBasic());
this.myOptions = new RequestOptions({ headers: myHeaders });

      this.http
           .get(this.apiConfigService.getUrlApi() + "produits", this.myOptions)
           .subscribe(resp => {
               for (let p of resp.json()._embedded.produits) {
                   this.produits.push(new Produit(p));
               }
           });


}



public findAll() : Array<Produit>{
  return this.produits;
}

public findAllByNom(nom: string) : Array<Produit> {

  return this.produits.filter(p =>
      p.nom
          .toLowerCase()
          .indexOf(nom.toLowerCase()) !== -1
  )
}

public save(produit){
if (this.produits.indexOf(produit) === -1){
  // this.produits.push(produit);

  produit.gamme = this.apiConfigService.getUrlApi()+"gammes/1"
this.http

  .post(this.apiConfigService.getUrlApi()+"produits", produit, this.myOptions)
  .subscribe(resp => this.produits.push(produit), err => alert("erreur dans le prix"));
}
else{
  this.http
      .put(produit.getHref(), produit, this.myOptions)
    .subscribe(resp => alert("modif ok")/*this.produits.push(resp.json())*/, err => alert (err));
}
}
public delete(produit){
let myIndex: number = this.produits.indexOf(produit);
this.http
    .delete(produit.getHref(), this.myOptions)
  .subscribe(resp => this.produits.splice(myIndex, 1));

}
}
