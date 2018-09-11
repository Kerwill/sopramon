import { Injectable } from '@angular/core';
import { Combat } from './combat';
import { Http, Headers, RequestOptions } from '@angular/http';
import { AppConfigService } from './app-config.service';

@Injectable()
export class CombatService {
    private combats: Array<Combat> = new Array<Combat>();
    private requestOptions: RequestOptions;

    constructor(private http: Http, private appConfigService: AppConfigService ) {
      let myHeaders: Headers = new Headers();

      myHeaders.append('Authorization', this.appConfigService.getApiBasic());
      this.requestOptions = new RequestOptions({ headers: myHeaders });


       this.http
            .get(this.appConfigService.getApiUrl() + "combats", this.requestOptions)
            .subscribe(resp => {
                for (let p of resp.json()._embedded.combats) {
                    this.combats.push(new Combat(p));
                }
            });
    }

    public findAll(): Array<Combat> {
        return this.combats;
    }


    public save(combat: Combat) {
        if (this.combats.indexOf(combat) === -1) {
            combat.setSopramon1(this.appConfigService.getApiUrl() + "sopramon1/4");
            combat.setSopramon2(this.appConfigService.getApiUrl() + "sopramon2/5");
            combat.setBoss(this.appConfigService.getApiUrl() + "boss/2");
            this.http
                .post(this.appConfigService.getApiUrl() + "combats", combat, this.requestOptions)
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
            .delete(combat.getHref(), this.requestOptions)
            .subscribe(resp => this.combats.splice(myIndex, 1));
    }
}
