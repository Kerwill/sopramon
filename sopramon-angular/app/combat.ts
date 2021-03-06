export class Combat {
    private tour:number;
    private attaquant1: string;
    private attaquant2: string;
    private href: string;
    private username : string;

    constructor(private json?: any) {
        if (json !== undefined) {
            this.tour = json.tour;
            this.attaquant1 = json.attaquant1;
            this.attaquant2 = json.attaquant2;
            if (json._links !== undefined) {
                this.href = json._links.self.href;
            }
        }
    }

    public getTour(): number {
        return this.tour;
    }

    public getHref(): string {
        return this.href;
    }

    public getAttaquant1(): any {
        return this.attaquant1;
    }

    public getAttaquant2(): any {
        return this.attaquant2;
    }


    public getUsername(): string {
        return this.username;
    }

    public setAttaquant1(attaquant1: string) {
        this.attaquant1 = attaquant1;
    }

    public setAttaquant2(attaquant2: string) {
        this.attaquant2 = attaquant2;
    }



    public setUsername(username : string) {
        this.username = username;
    }


}
