package com.ProyectoIntegrador.ProyectoIntegrador.service;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.PoliticaDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Politica;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.PoliticaRepository;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliticaService {
    private PoliticaRepository politicaRepository;

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    public PoliticaService(PoliticaRepository politicaRepository) { this.politicaRepository = politicaRepository; }

    public List<Politica> listarPoliticas() { return politicaRepository.findAll(); }

    public Optional<Politica> buscarPoliticaXId(Long id) { return politicaRepository.findById(id); }

    public Politica guardarPolitica(Politica politica) { return politicaRepository.save(politica); }

    public Politica actualizarPolitica(Politica politica) { return politicaRepository.save(politica); }

    public void eliminarPolitica(Long id) { politicaRepository.deleteById(id); }

    private Politica politicaDTOAPolitica(PoliticaDTO politicaDTO){
        Politica politica = new Politica();
        politica.setId(politicaDTO.getId());
        politica.setTitulo(politicaDTO.getTitulo());
        politica.setDetalle(politicaDTO.getDetalle());
        return politica;
    }

    private PoliticaDTO politicaAPoliticaDTO(Politica politica){
        PoliticaDTO politicaDTO = new PoliticaDTO();
        politicaDTO.setId(politica.getId());
        politicaDTO.setTitulo(politica.getTitulo());
        politicaDTO.setDetalle(politica.getDetalle());
        return politicaDTO;
    }
}
