export class Item {

    private nom: string = "";
    public getNom(): string {
        return this.nom;
    }
    private prix : number;
    public getPrix(): number {
        return this.prix;
    }

  private capacite: string;
  private href: string;



    constructor(private json?: any) {
        if (json !== undefined) {
            this.nom = json.nom;
            this.prix = json.prix;
            this.capacite = json.capacite;

            if (json._links !== undefined) {
                this.href = json._links.self.href;
            }
        }
    }
    public setCapacite(capacite: string) {
        this.capacite = capacite;
    }

    public getCapacite() : string {
        return this.capacite;
    }


    public getHref(): string {
    return this.href;
}
  }
