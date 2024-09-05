import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductoListaComponent } from './producto/producto-lista/producto-lista.component';
import { AgregarComponent } from './producto/agregar/agregar.component';
import { EditarComponent } from './producto/editar/editar.component';

// http:localhost:4200/productos
const routes: Routes = [
  { path: 'productos', component: ProductoListaComponent },
  { path: 'agregar', component: AgregarComponent },
  { path: '', redirectTo: 'productos', pathMatch: 'full' },
  {path: 'editar-producto/:id', component:  EditarComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
