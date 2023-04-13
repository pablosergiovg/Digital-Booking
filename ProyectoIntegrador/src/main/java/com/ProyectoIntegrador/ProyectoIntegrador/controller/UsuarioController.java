package com.ProyectoIntegrador.ProyectoIntegrador.controller;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.UsuarioDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Usuario;
import com.ProyectoIntegrador.ProyectoIntegrador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){ this.usuarioService = usuarioService; }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/datos/{email}")
    public ResponseEntity<Optional<UsuarioDTO>> buscarUsuarioPorEmail(@PathVariable String email){
        Optional<UsuarioDTO> usuarioBuscado = usuarioService.buscarUsuarioXEmail(email);
        if (usuarioBuscado.isPresent()){
            return ResponseEntity.ok(usuarioBuscado);
        } else {
            return ResponseEntity.status((HttpStatus.NOT_FOUND)).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioDTO>> buscarUsuarioPorId(@PathVariable Long id){
        Optional<UsuarioDTO> usuarioBuscado = usuarioService.buscarUsuarioXId(id);
        if (usuarioBuscado.isPresent()){
            return ResponseEntity.ok(usuarioBuscado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return  ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardarUsuario(usuarioDTO));

    }

}
