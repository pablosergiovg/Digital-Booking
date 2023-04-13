package com.ProyectoIntegrador.ProyectoIntegrador.controller;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.ReservaDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reservas")
@CrossOrigin("*")
public class ReservaController {

    private ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService){ this.reservaService = reservaService; }

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> buscarReservas(){
        return ResponseEntity.ok(reservaService.listarReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ReservaDTO>> buscarReservaPorId(@PathVariable Long id){
        Optional<ReservaDTO> reservaBuscada = reservaService.buscarReservaXId(id);
        if (reservaBuscada.isPresent()){
            return ResponseEntity.ok(reservaBuscada);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<ReservaDTO>> buscarReservasPorIdProducto(@PathVariable Long idProducto) {
        return ResponseEntity.ok(reservaService.buscarReservaXIdProducto(idProducto));
    }
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ReservaDTO>> buscarReservasPorIdUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(reservaService.buscarReservaXIdProducto(idUsuario  ));
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> guardarReserva(@RequestBody ReservaDTO reservaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.guardarReserva(reservaDTO));
    }

    @PutMapping
    public ResponseEntity<String> actualizarReserva(ReservaDTO reservaDTO){
        Optional<ReservaDTO> reservaAActualizar = reservaService.buscarReservaXId(reservaDTO.getId());
        if (reservaAActualizar.isPresent()){
            reservaService.actualizarReserva(reservaDTO);
            return ResponseEntity.ok().body("Se actualizó la reserva con id: " + reservaDTO.getId());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar la reserva con id: " + reservaDTO.getId() + ", verificar que esa reserva existe en al base de datos.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReserva(@PathVariable Long id){
        Optional<ReservaDTO> reservaAEliminar = reservaService.buscarReservaXId(id);
        if (reservaAEliminar.isPresent()){
            reservaService.elminarReserva(id);
            return ResponseEntity.ok().body("Se eliminó la reserva con id: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo eliminar la reserva con id: " + id + ", verificar que esa reserva existe en al base de datos.");
        }
    }

}
