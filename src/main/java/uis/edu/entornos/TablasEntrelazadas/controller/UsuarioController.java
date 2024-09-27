package uis.edu.entornos.TablasEntrelazadas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uis.edu.entornos.TablasEntrelazadas.models.Usuario;
import uis.edu.entornos.TablasEntrelazadas.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/tienda/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/registros")
    public List<Usuario> mostrarUsuarios(){
        return usuarioService.getUsuarios();
    }
    @GetMapping("/{id}")
    public Usuario buscarUsuarioId(@PathVariable Long id){
        return usuarioService.buscarUsuario(id);
    }
    @PostMapping("/")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.nuevoUsuario(usuario), HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<Usuario> editiar(@RequestBody Usuario usuario){
        Usuario obj = usuarioService.buscarUsuario(usuario.getId());
        if(obj != null){
            obj.setEmail(usuario.getEmail());
            obj.setNombre(usuario.getNombre());
            obj.setIdTipoDocumento(usuario.getIdTipoDocumento());
            obj.setNumeroDocumento(usuario.getNumeroDocumento());
            obj.setNombreUsuario(usuario.getNombreUsuario());
            obj.setPassword(usuario.getPassword());
            usuarioService.nuevoUsuario(obj);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Long id){
        Usuario obj = usuarioService.buscarUsuario(id);
        if(obj != null){
            usuarioService.borrarUsuario(id);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
