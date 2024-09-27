package uis.edu.entornos.TablasEntrelazadas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uis.edu.entornos.TablasEntrelazadas.models.Cliente;
import uis.edu.entornos.TablasEntrelazadas.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/tienda/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/registros")
    public List<Cliente> mostrarClientes(){
        return clienteService.getClientes();
    }
    @GetMapping("/{id}")
    public Cliente buscarClienteId(@PathVariable Long id){
        return clienteService.buscarClienteId(id);
    }
    @PostMapping("/")
    public ResponseEntity<Cliente> agregar(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.guardarCliente(cliente), HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente){
        Cliente obj = clienteService.buscarClienteId(cliente.getId());
        if(obj != null){
            obj.setNombre(cliente.getNombre());
            obj.setIdTipoDocumento(cliente.getIdTipoDocumento());
            obj.setNumeroDocumento(cliente.getNumeroDocumento());
            obj.setEmail(cliente.getEmail());
            obj.setDireccion(cliente.getDireccion());
            obj.setTelefono(cliente.getTelefono());
            clienteService.guardarCliente(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> borrar(@PathVariable Long id){
        Cliente obj = clienteService.buscarClienteId(id);
        if(obj != null){
            clienteService.borrarCliente(id);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
