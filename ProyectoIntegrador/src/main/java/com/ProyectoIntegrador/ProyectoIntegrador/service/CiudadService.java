package com.ProyectoIntegrador.ProyectoIntegrador.service;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.CiudadDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Ciudad;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {
    private CiudadRepository ciudadRepository;

    @Autowired
    public CiudadService(CiudadRepository ciudadRepository) { this.ciudadRepository = ciudadRepository; }

    public List<Ciudad> listarCiudades() { return ciudadRepository.findAll(); }

    public Optional<Ciudad> listarCiduadPorId(Long id){ return ciudadRepository.findById(id); }

    public Ciudad guardarCiudad(Ciudad ciudad) { return ciudadRepository.save(ciudad); }

    public void actualizarCiudad(Ciudad ciudad) { ciudadRepository.save(ciudad); }

    public void eliminarCiudad(Long id) { ciudadRepository.deleteById(id); }

    private Ciudad ciudadDTOACiudad(CiudadDTO ciudadDTO){
        Ciudad ciudad = new Ciudad();
        ciudad.setId(ciudadDTO.getId());
        ciudad.setNombre(ciudadDTO.getNombre());
        ciudad.setProvincia(ciudadDTO.getProvincia());
        ciudad.setPais(ciudadDTO.getPais());
        return ciudad;
    }

    private CiudadDTO ciudadACiudadDTO(Ciudad ciudad){
        CiudadDTO ciudadDTO = new CiudadDTO();
        ciudadDTO.setId(ciudad.getId());
        ciudadDTO.setNombre(ciudad.getNombre());
        ciudadDTO.setPais(ciudad.getPais());
        ciudadDTO.setProvincia(ciudad.getProvincia());
        return ciudadDTO;
    }
}
