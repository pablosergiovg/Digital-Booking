package com.ProyectoIntegrador.ProyectoIntegrador.controller;

import com.ProyectoIntegrador.ProyectoIntegrador.model.Ciudad;
import com.ProyectoIntegrador.ProyectoIntegrador.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ciudades")
@CrossOrigin("*")
public class CiudadController {

    private CiudadService ciudadService;

    @Autowired
    public CiudadController(CiudadService ciudadService) { this.ciudadService = ciudadService; }

    @GetMapping
    public ResponseEntity<List<Ciudad>> buscarCiudades(){
        return ResponseEntity.ok(ciudadService.listarCiudades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Ciudad>> buscarCiudadPorId(@PathVariable Long id){
        Optional<Ciudad> ciudadBuscada = ciudadService.listarCiduadPorId(id);
        if (ciudadBuscada.isPresent()){
            return ResponseEntity.ok(ciudadBuscada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Ciudad> agregarCiudad(@RequestBody Ciudad ciudad){
        return ResponseEntity.ok(ciudadService.guardarCiudad(ciudad));
    }

    @PutMapping
    public ResponseEntity<String> actualizarCiudad(@RequestBody Ciudad ciudad){
        Optional<Ciudad> ciudadBuscada = ciudadService.listarCiduadPorId(ciudad.getId());
        if (ciudadBuscada.isPresent()){
            ciudadService.actualizarCiudad(ciudad);
            return ResponseEntity.ok("Se actualizó la ciudad con Id: " + ciudad.getId());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar la ciudad con id: " + ciudad.getId() + ", verificar si existe esa ciudad en la base de datos.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarCiudad(@PathVariable Long id){
        Optional<Ciudad> ciudadBuscada = ciudadService.listarCiduadPorId(id);
        if (ciudadBuscada.isPresent()){
            ciudadService.eliminarCiudad(id);
            return ResponseEntity.ok("Se eliminó la ciudad con id: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo borrar la ciduad con id: " + id + ", verificar si existe esa ciudad en la base de datos.");
        }
    }
}
