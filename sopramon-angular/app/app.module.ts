import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { CombatComponent } from './combat.component';
import { AppConfigService} from './app-config.service';
import { CombatService } from './combat.service';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  { path: 'combat', component: CombatComponent },
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

    declarations: [
        AppComponent,
        CombatComponent
    ],

    bootstrap: [ AppComponent ]
})
export class AppModule { }
