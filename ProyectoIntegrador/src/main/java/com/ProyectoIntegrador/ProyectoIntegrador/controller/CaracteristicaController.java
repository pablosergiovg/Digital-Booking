package com.ProyectoIntegrador.ProyectoIntegrador.controller;

import com.ProyectoIntegrador.ProyectoIntegrador.model.Caracteristica;
import com.ProyectoIntegrador.ProyectoIntegrador.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/caracteristicas")
@CrossOrigin("*")
public class CaracteristicaController {
    private CaracteristicaService caracteristicaService;

    @Autowired
    public CaracteristicaController(CaracteristicaService caracteristicaService) { this.caracteristicaService = caracteristicaService; }

    @GetMapping
    public ResponseEntity<List<Caracteristica>> listarCaracteristicas(){ return ResponseEntity.ok(caracteristicaService.listarCaracteristica()); }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Caracteristica>> buscarCategoriaPorId(@PathVariable Long id) {
        Optional<Caracteristica> caracteristicaBuscada = caracteristicaService.listarCaracteristicaXId(id);
        if (caracteristicaBuscada.isPresent()){
            return ResponseEntity.ok(caracteristicaBuscada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Caracteristica> agregarCategoria(@RequestBody Caracteristica caracteristica){
        return ResponseEntity.ok(caracteristicaService.guardarCaracteristica(caracteristica));
    }

    @PutMapping
    public ResponseEntity<String> actualizarCategoria(@RequestBody Caracteristica caracteristica) {
        Optional<Caracteristica> caracteristicaBuscada = caracteristicaService.listarCaracteristicaXId(caracteristica.getId());
        if (caracteristicaBuscada.isPresent()){
            caracteristicaService.actualizarCaracteristica(caracteristica);
            return ResponseEntity.ok("Se actualizó la caracteristica con id: " + caracteristica.getId());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar actualizar la caracteristica con id: " + caracteristica.getId() + ", verificar que esa categoria existe en la base de datos.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCaracteristica(@PathVariable Long id) {
        Optional<Caracteristica> caracteristicaBuscada = caracteristicaService.listarCaracteristicaXId(id);
        if (caracteristicaBuscada.isPresent()){
            caracteristicaService.eliminarCaracteristica(id);
            return ResponseEntity.ok("Se eliminó la caracteristica con id: " + id);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo eliminar la caracteristica con id + " + id + ", verificar que esa caracteristica existe en la base de datos.");
        }
    }
}
