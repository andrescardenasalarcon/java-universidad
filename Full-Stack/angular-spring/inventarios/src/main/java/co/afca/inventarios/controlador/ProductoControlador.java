package co.afca.inventarios.controlador;

import co.afca.inventarios.excepcion.RecursoNoEncontradoExcepcion;
import co.afca.inventarios.modelo.Producto;
import co.afca.inventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://locahost:8080/inventario-app
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
//URL para realizar la peticion desde Angular --> habilita el cors de java para permitir esta ruta
public class ProductoControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    //http://locahost:8080/inventario-app/productos
    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> obtenerProductos() {
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos obtenidos:");
        productos.forEach((producto -> logger.info(producto.toString())));
        return ResponseEntity.ok(productos);
    }

    @PostMapping("/productos")
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        logger.info("Producto a agregar: " + producto);
        Producto productTmp = this.productoServicio.guardarProducto(producto);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(productTmp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id: " + id);
            //return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoRecibido) {
        Producto productoTmp = this.productoServicio.buscarProductoPorId(id);
        if (productoTmp != null) {
            productoTmp.setDescripcion(productoRecibido.getDescripcion());
            productoTmp.setPrecio(productoRecibido.getPrecio());
            productoTmp.setExistencia(productoRecibido.getExistencia());
            return ResponseEntity.ok(productoServicio.guardarProducto(productoTmp));
        } else {
            throw new RecursoNoEncontradoExcepcion("No se pudo editar el producto con id: " + id);
        }
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id) {
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if (producto == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        }
        productoServicio.eliminarProductoPorId(producto.getId());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

