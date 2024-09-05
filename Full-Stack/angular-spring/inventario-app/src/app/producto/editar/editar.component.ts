import { Component } from '@angular/core';
import { Producto } from '../../models/producto';
import { ProductoService } from '../../service/producto.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrl: './editar.component.css'
})
export class EditarComponent {
  producto: Producto = new Producto(0, "", 0, 0);
  id: number = 0;

  constructor(private privateService: ProductoService, private ruta: ActivatedRoute, private router: Router) {

  }

  ngOnInit() {
    this.id = this.ruta.snapshot.params['id'];
    this.privateService.obtenerProductoPorId(this.id).subscribe((dato: any) => {
      {
        const mapped: Producto = {
          idProducto: dato.id,
          descripcion: dato.descripcion,
          precio: dato.precio,
          existencia: dato.existencia
        }
        this.producto = mapped;

      }
    }

    );

  }

  onSubmit() {
    this.editarProducto();
  }

  editarProducto() {
    this.privateService.actualizarProductoPorId(this.id, this.producto).subscribe(
      {
        next: (datos) => this.irProductoLista(),
        error(err) {
          console.log(err);
        },
      }
    );
  }

  irProductoLista() {
    this.router.navigate(['/productos']);
  }
}
