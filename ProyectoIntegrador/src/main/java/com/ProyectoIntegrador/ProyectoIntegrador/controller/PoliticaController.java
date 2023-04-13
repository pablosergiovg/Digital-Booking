package com.ProyectoIntegrador.ProyectoIntegrador.controller;

import com.ProyectoIntegrador.ProyectoIntegrador.model.Politica;
import com.ProyectoIntegrador.ProyectoIntegrador.service.PoliticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/politicas")
@CrossOrigin("*")
public class PoliticaController {
    private PoliticaService politicaService;

    @Autowired
    public PoliticaController(PoliticaService politicaService) { this.politicaService = politicaService; }

    @GetMapping
    public ResponseEntity<List<Politica>> listarPoliticas() { return ResponseEntity.ok(politicaService.listarPoliticas()); }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Politica>> listarPoliticaPorId(@PathVariable Long id) {
        Optional<Politica> politicaBuscada = politicaService.buscarPoliticaXId(id);
        if (politicaBuscada.isPresent()){
            return ResponseEntity.ok(politicaBuscada);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping
    public ResponseEntity<Politica> agregarPolitica(@RequestBody Politica politica){
        return ResponseEntity.ok(politicaService.guardarPolitica(politica));
    }

    @PutMapping
    public ResponseEntity<String> actualizarPolitica(@RequestBody Politica politica){
        Optional<Politica> politicaBuscada = politicaService.buscarPoliticaXId(politica.getId());
        if (politicaBuscada.isPresent()){
            politicaService.actualizarPolitica(politica);
            return ResponseEntity.ok("Se actualizó la politica con id: " + politica.getId());
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar la politica con id: " + politica.getId() + ", verificar si existe esa politica en la base de datos.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPolitica(@PathVariable Long id){
        Optional<Politica> politicaBuscada = politicaService.buscarPoliticaXId(id);
        if (politicaBuscada.isPresent()){
            politicaService.eliminarPolitica(id);
            return ResponseEntity.ok("Se eliminó la politica con id: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo eliminar la politica con id: " + id + ", verificar si existe esa politica en la base de datos.");
        }
    }
}
