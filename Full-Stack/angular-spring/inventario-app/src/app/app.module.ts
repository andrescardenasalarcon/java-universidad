import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductoListaComponent } from './producto/producto-lista/producto-lista.component';
import { HttpClient, provideHttpClient } from '@angular/common/http';
import { AgregarComponent } from './producto/agregar/agregar.component';
import { FormsModule } from '@angular/forms';
import { EditarComponent } from './producto/editar/editar.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductoListaComponent,
    AgregarComponent,
    EditarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule
  ],
  providers: [provideHttpClient()], //provides the HttpClient() for the REQUESTS
  bootstrap: [AppComponent]
})
export class AppModule { }
