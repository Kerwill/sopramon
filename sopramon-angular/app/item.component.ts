import { Component } from '@angular/core';
import { Item } from './item';



@Component({
    templateUrl: 'app/item.component.html',
    styleUrls: [ 'app/produit.component.css' ]
})
export class ItemComponent {

    constructor(private produitService: ProduitService) { }


    private prenom: string = "Jérémy";
    private produit: Produit = new Produit("Saisir le nom", 10);

    private filtre: string = "";
    private isEditing : boolean = false;


    // constructor() {
    //     this.produits.push(new Produit("GoPRO HERO 6", 499.99));
    // }

    public changePrenom() {
        this.prenom = "AUTRE PRÉNOM";
    }

    getProduits(): Array<Produit> {
      return this.produitService.findAll();
    }

    public addProduit() {
      if (!this.isEditing){
        this.produitService.save(this.produit);
    }
      this.produit = new Produit();
      this.isEditing = false;
}

public supprimerProduit(produit : Produit){

      this.produitService.delete(produit);
}


public modifierProduit(produit: Produit)
{
  this.produit = produit;
  this.isEditing = true;
}


public filtrerProduits(): Array<Produit> {
        return this.produitService.findAllByNom(this.filtre);

    }
}
