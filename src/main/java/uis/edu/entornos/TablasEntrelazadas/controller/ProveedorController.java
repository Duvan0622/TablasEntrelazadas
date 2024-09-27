package uis.edu.entornos.TablasEntrelazadas.controller;

import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uis.edu.entornos.TablasEntrelazadas.models.Proveedor;
import uis.edu.entornos.TablasEntrelazadas.service.ProveedorService;

import java.util.List;

@RestController
@RequestMapping("/tienda/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/registros")
    public List<Proveedor> mostrarProveedores(){
        return proveedorService.getProveedores();
    }
    @GetMapping("/{id}")
    public Proveedor buscarProveedorId(@PathVariable Long id){
        return proveedorService.buscarProveedor(id);
    }
    @PostMapping("/")
    public ResponseEntity<Proveedor> agregar(@RequestBody Proveedor proveedor){
        return new ResponseEntity<>(proveedorService.guardarProveedor(proveedor), HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<Proveedor> editar(@RequestBody Proveedor proveedor){
        Proveedor obj = proveedorService.buscarProveedor(proveedor.getId());
        if(obj != null){
            obj.setNombre(proveedor.getNombre());
            obj.setCiudad(proveedor.getCiudad());
            obj.setDireccion(proveedor.getDireccion());
            obj.setNit(proveedor.getNit());
            obj.setTelefono(proveedor.getTelefono());
            proveedorService.guardarProveedor(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Proveedor> borrar(@PathVariable Long id){
        Proveedor obj = proveedorService.buscarProveedor(id);
        if(obj != null){
            proveedorService.borrarProveedor(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
