import { Component } from '@angular/core';
import { Combat } from './combat';
import { CombatService } from './combat.service';


@Component({
    templateUrl: 'app/combat.component.html',
    styleUrls: [ 'app/combat.component.css' ]
})
export class CombatComponent {
    private combat: Combat = new Combat();
    // private combats: Array<Combat> = new Array<Combat>();
    private filtre: string = "";


    constructor(private combatService: CombatService) {
    }

    public getCombats(): Array<Combat> {
      return this.combatService.findAll();
    }

    public addCombat() {
        this.combatService.save(this.combat);
        this.combat = new Combat();
}

    public filtrerCombat(): Array<Combat> {
        return this.combatService.findAllByAttaquant();
    }

    // public connect() {
    //     this.isConnecting = true;
    //         this.CombatService.addUtilisateur();
    // }

}
