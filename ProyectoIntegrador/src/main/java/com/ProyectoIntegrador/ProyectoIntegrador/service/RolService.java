package com.ProyectoIntegrador.ProyectoIntegrador.service;

import com.ProyectoIntegrador.ProyectoIntegrador.model.Rol;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class RolService {
    private RolRepository rolRepository;

    @Autowired
    private RolService (RolRepository rolRepository) { this.rolRepository = rolRepository; }

    public List<Rol> listarRoles(){ return rolRepository.findAll(); }

    public Optional<Rol> buscarRolPorId(Long id){ return rolRepository.findById(id); }
}
