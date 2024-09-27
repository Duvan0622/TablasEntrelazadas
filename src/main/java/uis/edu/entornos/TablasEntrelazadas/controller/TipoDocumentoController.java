package uis.edu.entornos.TablasEntrelazadas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uis.edu.entornos.TablasEntrelazadas.models.TipoDocumento;
import uis.edu.entornos.TablasEntrelazadas.service.TipoDocumentoService;

import java.util.List;

@RestController
@RequestMapping("/tienda/documento")
public class TipoDocumentoController {
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    @GetMapping("/registros")
    public List<TipoDocumento> mostrarTiposDocumentos(){
        return tipoDocumentoService.getTipoDocumentos();
    }
    @GetMapping("/{id}")
    public TipoDocumento buscarDocumentoId(@PathVariable Long id){
        return tipoDocumentoService.buscarTipoDocumento(id);
    }
    @PostMapping("/")
    public ResponseEntity<TipoDocumento> agregar(@RequestBody TipoDocumento tipoDocumento){
        return new ResponseEntity<>(tipoDocumentoService.guardarTipoDocumento(tipoDocumento), HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<TipoDocumento> editar(@RequestBody TipoDocumento tipoDocumento){
        TipoDocumento obj =  tipoDocumentoService.buscarTipoDocumento(tipoDocumento.getId());
        if(obj != null){
            obj.setTipo(tipoDocumento.getTipo());
            tipoDocumentoService.guardarTipoDocumento(obj);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TipoDocumento> borrar(@PathVariable Long id){
        TipoDocumento obj = tipoDocumentoService.buscarTipoDocumento(id);
        if(obj != null){
            tipoDocumentoService.borrarTipoDocumento(id);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
