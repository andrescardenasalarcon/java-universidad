import { ProductoService } from '../../service/producto.service';
import { Producto } from './../../models/producto';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrl: './agregar.component.css'
})
export class AgregarComponent {
  producto: Producto = new Producto(0, "", 0, 0);

  constructor(private productoService: ProductoService, private router: Router) {

  }

  onSubmit() {
    this.guardarProducto();
  }

  guardarProducto() {
    this.productoService.agregarProductos(this.producto).subscribe(
      {
        next: (datos) => {
            this.irListaProducto();
        },
        error: (err: any) => {
          console.log(err);
        },

      });
  }

  irListaProducto(){
    this.router.navigate(['/productos'])
  }

}
