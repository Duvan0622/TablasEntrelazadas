package uis.edu.entornos.TablasEntrelazadas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uis.edu.entornos.TablasEntrelazadas.models.Venta;
import uis.edu.entornos.TablasEntrelazadas.service.VentaService;

import java.util.List;

@RestController
@RequestMapping("/tienda/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping("/registros")
    public List<Venta> mostrarVentas(){
        return ventaService.getVentas();
    }
    @GetMapping("/{id}")
    public Venta buscarVentaId(@PathVariable Long id){
        return ventaService.buscarVenta(id);
    }
    @PostMapping("/")
    public ResponseEntity<Venta> agregar(@RequestBody Venta venta){
        return new ResponseEntity<>(ventaService.guardarVenta(venta), HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<Venta> editar(@RequestBody Venta venta){
        Venta obj = ventaService.buscarVenta(venta.getId());
        if (obj != null){
            obj.setIvaVenta(venta.getIvaVenta());
            obj.setValorVenta(venta.getValorVenta());
            obj.setTotalVenta(venta.getTotalVenta());
            obj.setIdUsuario(venta.getIdUsuario());
            obj.setIdCliente(venta.getIdCliente());
            ventaService.guardarVenta(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Venta> borrar(@PathVariable Long id){
        Venta obj = ventaService.buscarVenta(id);
        if(obj!= null){
            ventaService.borrarVenta(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
