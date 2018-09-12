export class Combat {
    private tour:number;
    private sopramon1: string;
    private sopramon2: string;
    private boss: string;
    private coups: string;
    private href: string;

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

    public getSopramon1(): string {
        return this.sopramon1;
    }

    public getSopramon2(): string {
        return this.sopramon2;
    }

    public getBoss(): string {
        return this.boss;
    }

    public setSopramon1(sopramon1: string) {
        this.sopramon1 = sopramon1;
    }

    public setSopramon2(sopramon2: string) {
        this.sopramon2 = sopramon2;
    }

    public setBoss(boss: string) {
        this.boss = boss;
    }

    public setCoups(coups: string) {
        this.coups = coups;
    }
}
