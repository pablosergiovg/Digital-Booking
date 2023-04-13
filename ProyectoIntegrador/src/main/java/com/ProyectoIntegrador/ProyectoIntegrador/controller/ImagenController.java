package com.ProyectoIntegrador.ProyectoIntegrador.controller;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.ImagenDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/imagenes")
@CrossOrigin("*")
public class ImagenController {

    private ImagenService imagenService;

    @Autowired
    public ImagenController(ImagenService imagenService) { this.imagenService = imagenService; }

    @GetMapping
    public ResponseEntity<List<ImagenDTO>> buscarImagenes(){ return ResponseEntity.ok(imagenService.listarImagenes()); }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ImagenDTO>> buscarImagenXId(@PathVariable Long id){
        Optional<ImagenDTO> imagenBuscada = imagenService.listarImagenXId(id);
        if (imagenBuscada.isPresent()){
            return ResponseEntity.ok(imagenService.listarImagenXId(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping
    public ResponseEntity<ImagenDTO> agregarImagen(@RequestBody ImagenDTO imagenDTO) {
        return ResponseEntity.ok(imagenService.guardarImagen(imagenDTO));
    }
    @PutMapping
    public ResponseEntity<String> actualizarImagen(@RequestBody  ImagenDTO imagenDTO){
        Optional<ImagenDTO> imagenBuscada = imagenService.listarImagenXId(imagenDTO.getId());
        if (imagenBuscada.isPresent()){
            imagenService.actualizarImagen(imagenDTO);
            return ResponseEntity.ok("Se actualizó la imagen con id: " + imagenDTO.getId());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar la imagen con id: " + imagenDTO.getId() + ", verificar si la imagen existe en la base de datos.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarImagen(@PathVariable Long id) {
        Optional<ImagenDTO> imagenBuscada = imagenService.listarImagenXId(id);
        if (imagenBuscada.isPresent()){
            imagenService.eliminarImagen(id);
            return ResponseEntity.ok("Se eliminó la imagen con id: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo eliminar la imagen con id: " + id + ", verificar si la imagen existe en la base de datos.");
        }
    }

}
