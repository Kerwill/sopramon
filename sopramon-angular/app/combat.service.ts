import { Injectable } from '@angular/core';
import { Combat } from './combat';
import { Http, Headers, RequestOptions } from '@angular/http';
import { AppConfigService } from './app-config.service';

@Injectable()
export class CombatService {
    private combats: Array<Combat> = new Array<Combat>();
    // private requestOptions: RequestOptions;

    constructor(private http: Http, private appConfigService: AppConfigService ) {
      // let myHeaders: Headers = new Headers();

      // myHeaders.append('Authorization', this.appConfigService.getApiBasic());
      // this.requestOptions = new RequestOptions({ headers: myHeaders });


       this.http
            .get(this.appConfigService.getUrlApi() + "combats")
            .subscribe(resp => {
                for (let p of resp.json()._embedded.combats) {
                    this.combats.push(new Combat(p));
                }
            });
    }

    public findAll(): Array<Combat> {
        return this.combats;
    }

    public findAllByAttaquant(attaquant1: string): Array<Combat> {
        return this.combats.filter(c =>
            c.getAttaquant1()
                .indexOf(attaquant1) !== -1
        );
    }


    public save(combat: Combat) {
        if (this.combats.indexOf(combat) === -1) {
            this.http
                .post(this.appConfigService.getUrlApi() + "combats", combat)
                .subscribe(resp => this.combats.push(new Combat(resp.json())));
        }

        else {
            this.http
                .put(combat.getHref(), combat)
                .subscribe();
        }
    }


    public delete(combat: Combat) {
        let myIndex: number = this.combats.indexOf(combat);
        this.http
            .delete(combat.getHref())
            .subscribe(resp => this.combats.splice(myIndex, 1));
    }

    public fixUsername() {
    }
}
