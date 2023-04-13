package com.ProyectoIntegrador.ProyectoIntegrador.service;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.CaracteristicaDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Caracteristica;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaService {
    private CaracteristicaRepository caracteristicaRepository;
    @Autowired
    public CaracteristicaService(CaracteristicaRepository caracteristicaRepository){this.caracteristicaRepository = caracteristicaRepository; }

    public List<Caracteristica> listarCaracteristica() {return caracteristicaRepository.findAll();}

    public Optional<Caracteristica> listarCaracteristicaXId(Long id) { return caracteristicaRepository.findById(id); }

    public Caracteristica guardarCaracteristica(Caracteristica caracteristica){ return caracteristicaRepository.save(caracteristica); }

    public void actualizarCaracteristica(Caracteristica caracteristica) { caracteristicaRepository.save(caracteristica); }

    public void eliminarCaracteristica(Long id) { caracteristicaRepository.deleteById(id); }

    private Caracteristica caracteristicaDTOACaracteristica(CaracteristicaDTO caracteristicaDTO){
        Caracteristica caracteristica = new Caracteristica();
        caracteristica.setId(caracteristicaDTO.getId());
        caracteristica.setIcono(caracteristicaDTO.getIcono());
        caracteristica.setNombre(caracteristicaDTO.getNombre());
        return caracteristica;
    }

    private CaracteristicaDTO caracteristicaACaracteristicaDTo(Caracteristica caracteristica){
        CaracteristicaDTO caracteristicaDTO = new CaracteristicaDTO();
        caracteristicaDTO.setId(caracteristica.getId());
        caracteristicaDTO.setNombre(caracteristicaDTO.getNombre());
        caracteristicaDTO.setIcono(caracteristicaDTO.getIcono());
        return caracteristicaDTO;
    }
}
