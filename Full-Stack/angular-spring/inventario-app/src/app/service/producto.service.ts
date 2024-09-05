import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from '../models/producto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private urlBase = 'http://localhost:8080/inventario-app/productos';

  constructor(private clienteHttp: HttpClient) { }

  public obtenerProductosLista(): Observable<[]> {
    return this.clienteHttp.get<[]>(this.urlBase);
  }

  public agregarProductos(producto: Producto): Observable<Object> {
    return this.clienteHttp.post(this.urlBase, producto);
  }

  public obtenerProductoPorId(id: number) {
    return this.clienteHttp.get(`${this.urlBase}/` + id);
  }
  
  public actualizarProductoPorId(id: number, producto: Producto): Observable<Object> {
    return this.clienteHttp.put(`${this.urlBase}/` + id, producto);
  }

  public eliminarProducto(id: number):Observable<Object>{
    return this.clienteHttp.delete(`${this.urlBase}/` + id);
  }
}
