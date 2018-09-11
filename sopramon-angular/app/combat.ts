export class Combat {
    private tour:number;
    private sopramon1: string;
    private sopramon1: string;
    private boss: string;
    private coups: string;



    constructor(private json?: any) {
        if (json !== undefined) {
            this.tour = json.tour;

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
