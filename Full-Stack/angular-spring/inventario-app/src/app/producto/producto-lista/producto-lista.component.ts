import { Component } from '@angular/core';
import { Producto } from '../../models/producto';
import { ProductoService } from '../../service/producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  templateUrl: './producto-lista.component.html',
  styleUrl: './producto-lista.component.css'
})
export class ProductoListaComponent {
  productos: Producto[] = [];

  constructor(private productoService: ProductoService, private router: Router) {

  }

  ngOnInit() {
    this.obtenerPorductos();
  }

  private obtenerPorductos() {
    this.productoService.obtenerProductosLista().subscribe((datos) => {
      this.productos = datos.map((producto: any) => ({
        idProducto: producto.id,
        descripcion: producto.descripcion,
        precio: producto.precio,
        existencia: producto.existencia
      }));
    })
  }

  editarProducto(id: number) {
    this.router.navigate(['editar-producto', id]);
  }

  eliminarProducto(id: number) {
    this.productoService.eliminarProducto(id).subscribe(
      {
        next: (datos) => this.obtenerPorductos(),
        error: (err) => console.log(err),
      }
    );
  }
}
