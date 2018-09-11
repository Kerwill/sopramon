import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { ItemComponent } from './item.component';
import { AppConfigService } from './app-config.service';
import { ItemService } from './item.service';
import { HttpModule } from '@angular/http';


const routes: Routes = [
  { path: 'item', component: ItemComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
    imports: [
      BrowserModule,
      FormsModule,
      RouterModule.forRoot(routes),
      HttpModule
    ],
providers : [AppConfigService, ItemService],
    declarations: [
      AppComponent,
    ItemComponent,
    ],

    bootstrap: [ AppComponent ]
})
export class AppModule { }
