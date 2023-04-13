package com.ProyectoIntegrador.ProyectoIntegrador.service;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.ImagenDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Imagen;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Producto;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.ImagenRepository;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImagenService {

    private ImagenRepository imagenRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    public ImagenService(ImagenRepository imagenRepository) { this.imagenRepository = imagenRepository; }

    public List<ImagenDTO> listarImagenes(){
        List<Imagen> imagenesEncontradas = imagenRepository.findAll();
        List<ImagenDTO> respuesta = new ArrayList<>();
        for (Imagen imagen : imagenesEncontradas) {
            respuesta.add(imagenAImagenDTO(imagen));
        }
        return respuesta;
    }

    public Optional<ImagenDTO> listarImagenXId(Long id) {
        Optional<Imagen> imagenBuscada = imagenRepository.findById(id);
        if (imagenBuscada.isPresent()) {
            return Optional.of(imagenAImagenDTO(imagenBuscada.get()));
        } else {
        return Optional.empty();
        }
    }

    public ImagenDTO guardarImagen(ImagenDTO imagenDTO) {
        Imagen imagenAGuardar = imagenDTOAImagen(imagenDTO);
        Imagen imagenGuardada = imagenRepository.save(imagenAGuardar);
        return imagenAImagenDTO(imagenGuardada);
    }

    public void actualizarImagen(ImagenDTO imagenDTO) {
        Imagen imagenAActualizar = imagenDTOAImagen(imagenDTO);
        imagenRepository.save(imagenAActualizar);
    }

    public void eliminarImagen(Long id) { imagenRepository.deleteById(id); }

    private Imagen imagenDTOAImagen(ImagenDTO imagenDTO){
        Imagen imagen = new Imagen();
        Producto producto = productoRepository.findById(imagenDTO.getProductoId()).get();
        System.out.println(producto);
        producto.addImagen(imagen);
        imagen.setId(imagenDTO.getId());
        imagen.setTitulo(imagenDTO.getTitulo());
        imagen.setUrlImagen(imagenDTO.getUrlImagen());
        imagen.setProducto(producto);

        return imagen;
    }

    private ImagenDTO imagenAImagenDTO(Imagen imagen){
        ImagenDTO imagenDTO = new ImagenDTO();
        imagenDTO.setId(imagen.getId());
        imagenDTO.setTitulo(imagen.getTitulo());
        imagenDTO.setUrlImagen(imagen.getUrlImagen());
        imagenDTO.setProductoId(imagen.getProducto().getId());
        return imagenDTO;
    }
}
