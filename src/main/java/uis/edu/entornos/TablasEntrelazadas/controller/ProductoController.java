package uis.edu.entornos.TablasEntrelazadas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uis.edu.entornos.TablasEntrelazadas.models.Producto;
import uis.edu.entornos.TablasEntrelazadas.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/tienda/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @GetMapping("/registros")
    public List<Producto> mostrarProductos(){
        return productoService.getProductos();
    }
    @GetMapping("/{id}")
    public Producto buscarProductoId(@PathVariable Long id){
        return productoService.buscarProducto(id);
    }
    @PostMapping("/")
    public ResponseEntity<Producto> agregar(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.guardarProducto(producto), HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<Producto> editar(@RequestBody Producto producto){
        Producto obj = productoService.buscarProducto(producto.getId());
        if(obj != null){
            obj.setNombre(producto.getNombre());
            obj.setIvaCompra(producto.getIvaCompra());
            obj.setIdProveedor(producto.getIdProveedor());
            obj.setPrecioCompra(producto.getPrecioCompra());
            obj.setPrecioVenta(producto.getPrecioVenta());
            productoService.guardarProducto(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> borrar(@PathVariable Long id){
        Producto obj = productoService.buscarProducto(id);
        if(obj!= null){
            productoService.borrarProducto(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
