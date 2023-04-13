package com.ProyectoIntegrador.ProyectoIntegrador.controller;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.CategoriaDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categorias")
@CrossOrigin("*")
public class CategoriaController {
    private CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) { this.categoriaService = categoriaService; }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> buscarCategorias(){
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriaDTO>> buscarCategoriaPorId(@PathVariable Long id) {
        Optional<CategoriaDTO> categoriaBuscada = categoriaService.buscarCategoriaXId(id);
        if( categoriaBuscada != null ){
            return ResponseEntity.ok(categoriaBuscada);
        }
        else {
//            return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> agregarCategoria(@RequestBody CategoriaDTO categoriaDTO){
        return ResponseEntity.ok(categoriaService.guardarCategoria(categoriaDTO));
    }

    @PutMapping
    public ResponseEntity<String> actualizarCategoria(@RequestBody CategoriaDTO categoria){
        Optional<CategoriaDTO> categoriaBuscada = categoriaService.buscarCategoriaXId(categoria.getId());
        if(categoriaBuscada != null){
            categoriaService.actualizarCategoria(categoria);
            return ResponseEntity.ok("Se actualizó la categoria con id: " + categoria.getId());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar la categoria con id: " + categoria.getId() + ", verificar si existe esa categoria en la base de datos.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long id){
        Optional<CategoriaDTO> categoriaBuscada = categoriaService.buscarCategoriaXId(id);
        if(categoriaBuscada != null){
            categoriaService.eliminarCategoria(id);
            return ResponseEntity.ok("Se eliminó la categoria con id: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo eliminar la categoria con id: " + id + ", verificar si existe esa categoria en la base de datos.");
        }
    }

}
