package com.ProyectoIntegrador.ProyectoIntegrador.repository;

import com.ProyectoIntegrador.ProyectoIntegrador.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
