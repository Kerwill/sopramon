import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { CombatComponent } from './combat.component';
import { CombatService } from './combat.service';
import { ItemComponent } from './item.component';
import { ItemService } from './item.service';
import { AppConfigService} from './app-config.service';
import { UtilisateurService } from './utilisateur.service';



const routes: Routes = [
  { path: 'combat', component: CombatComponent },
  { path: 'item', component: ItemComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
    imports: [
      BrowserModule,
      FormsModule,
      HttpModule,
      RouterModule.forRoot(routes),
    ],

    providers: [
      AppConfigService,
      CombatService,
      ItemService,
      UtilisateurService
    ],

    declarations: [
        AppComponent,
        CombatComponent,
        ItemComponent,
    ],

    bootstrap: [ AppComponent ]
})
export class AppModule { }
