package com.ProyectoIntegrador.ProyectoIntegrador.repository;

import com.ProyectoIntegrador.ProyectoIntegrador.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("select r from Reserva r where r.producto.id = ?1")
    List<Reserva> findReservaByIdProducto(Long id);
    @Query("select r from Reserva r where r.usuario.id = ?1")
    List<Reserva> findByReserva_Usuario_Id(Long id);

}
