package com.ProyectoIntegrador.ProyectoIntegrador.service;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.CategoriaDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Categoria;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) { this.categoriaRepository = categoriaRepository; }

    public List<CategoriaDTO> listarCategorias() {
        List<Categoria> categoriasBuscadas = categoriaRepository.findAll();
        List<CategoriaDTO> listaCategoriasDTO = new ArrayList<>();
        for (Categoria categoria : categoriasBuscadas) {
            listaCategoriasDTO.add(categoriaACategoriaDTO(categoria));
        }
        return listaCategoriasDTO;
    }

    public Optional<CategoriaDTO> buscarCategoriaXId(Long id) {
        Optional<Categoria> categoriaBuscada= categoriaRepository.findById(id);
        if(categoriaBuscada.isPresent()){
            return Optional.of(categoriaACategoriaDTO(categoriaBuscada.get()));
        } else {
            return Optional.empty();
        }
    }

    public CategoriaDTO guardarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoriaAGuardar = categoriaDTOaCategoria(categoriaDTO);
        Categoria categoriaGuardada = categoriaRepository.save(categoriaAGuardar);
        return categoriaACategoriaDTO(categoriaGuardada);
    }

    public void actualizarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoriaAActualizar = categoriaDTOaCategoria(categoriaDTO);
        categoriaRepository.save(categoriaAActualizar);
    }

    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    private CategoriaDTO categoriaACategoriaDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setTitulo(categoria.getTitulo());
        categoriaDTO.setDescripcion(categoria.getDescripcion());
        categoriaDTO.setUrlimagen(categoria.getUrlImagen());
        return categoriaDTO;
    }

    private Categoria categoriaDTOaCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaDTO.getId());
        categoria.setTitulo(categoriaDTO.getTitulo());
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        categoria.setUrlImagen(categoriaDTO.getUrlimagen());
        return categoria;
    }

}
