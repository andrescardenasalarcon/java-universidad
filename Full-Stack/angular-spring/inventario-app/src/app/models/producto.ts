export class Producto {
    idProducto: number;
    descripcion: string;
    precio: number;
    existencia : number;

    constructor(idProducto: number, descripcion: string, precio: number, existencia: number){
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
    }

    
}
