import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { CombatComponent } from './combat.component';
import { AppConfigService} from './app-config.service';
import { CombatService } from './combat.service';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { ItemComponent } from './item.component';
import { AppConfigService } from './app-config.service';
import { ItemService } from './item.service';
import { HttpModule } from '@angular/http';


const routes: Routes = [
  { path: 'combat', component: CombatComponent },
  ];

const routes: Routes = [
  { path: 'item', component: ItemComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
    imports: [
      BrowserModule,
      FormsModule,
      HttpModule
      RouterModule.forRoot(routes),
    ],

    providers: [
      AppConfigService,
      CombatService
    ],

providers : [AppConfigService, ItemService],
    declarations: [
        AppComponent,
        CombatComponent
      AppComponent,
    ItemComponent,
    ],

    bootstrap: [ AppComponent ]
})
export class AppModule { }
