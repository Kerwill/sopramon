export class Achat {

    private prix: number;
    public getPrix(): number {
        return this.prix;
    }
    private date : any;
    public getDate(): any {
        return this.date;
    }
    private href: string;

    constructor(private json?: any) {
        if (json !== undefined) {
            this.prix = json.prix;
            this.date = json.date;

            if (json._links !== undefined) {
                this.href = json._links.self.href;
            }
        }
    }

    public getHref(): string {
    return this.href;
}
  }
