import { Component, Input } from '@angular/core';
import { Achat } from './achat';
import { AchatService } from './achat.service';
import { Item } from './item';


@Component({
    selector: 'achat-row',
    templateUrl: 'app/achat.component.html',
    styleUrls: [ 'app/achat.component.css' ]
})

export class AchatComponent {

  constructor(private achatService: AchatService) { }

private isBuying : boolean = false;



  @Input('item') private item: Item;


    public cancel() {
        this.isBuying = false;
    }


    public askAchat() {
        this.isBuying = true;
    }


    public buy() {
      this.achatService.add(this.item);
      this.isBuying = false;
    }
}
