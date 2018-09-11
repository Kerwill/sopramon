import { Component } from '@angular/core';
import { Item } from './item';
import { ItemService } from './item.service';


@Component({
    templateUrl: 'app/item.component.html',
    styleUrls: [ 'app/item.component.css' ]
})
export class ItemComponent {

    constructor(private itemService: ItemService) { }

    getItems(): Array<Item> {
      return this.itemService.findAll();
    }
}
