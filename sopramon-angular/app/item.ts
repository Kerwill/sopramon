export class Item {

    private nom: string = "";
    public getNom(): string {
        return this.nom;
    }
    private prix : number = 0;
    public getPrix(): number {
        return this.number;
    }

  private Capacite: string;
  private gamme: string;


    constructor(private json?: any) {
        if (json !== undefined) {
            this.nom = json.nom;
            this.prix = json.prix;

            if (json._links !== undefined) {
                this.href = json._links.self.href;
            }
        }
    }
    public setCapacite(capacite: string) {
        this.capacite = capacite;
    }


    public getHref(): string {
    return this.href;
}
  }
