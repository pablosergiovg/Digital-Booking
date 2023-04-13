package com.ProyectoIntegrador.ProyectoIntegrador.service;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.ProductoDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Categoria;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Ciudad;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Producto;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) { this.productoRepository = productoRepository; }

    public List<Producto> listarProductos() { return productoRepository.findAll(); }

    public Optional<Producto> buscarProductoXId(Long id) { return productoRepository.findById(id); }

    public List<Producto> buscarProductoXCategoria(String categoria) { return productoRepository.filtrarPorCategoria(categoria); }

    public List<Producto> buscarProductoXciudad(String ciudad) {return productoRepository.filtrarPorCiudad(ciudad); }

    public List<Producto> buscarProductosXCiudadYFecha(LocalDate fechaInicio, LocalDate fechaFinal, Long idCiudad){ return productoRepository.filtrarPorCiudadYFecha( fechaInicio, fechaFinal, idCiudad); }

    public List<Producto> buscarProductosFavoriteadosPorUsuarioId(Long id){
        return productoRepository.findProductoByUsuarioId(id);
    }
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    public void actualizarProducto(Producto producto) { productoRepository.save(producto); }

    public void eliminarProducto(Long id) { productoRepository.deleteById(id); }


    private ProductoDTO productoAProductoDTO(Producto producto){
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setTitulo(producto.getTitulo());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setCategoriaID(producto.getCategoria().getId());
        productoDTO.setCiudadID(producto.getCiudad().getId());
        productoDTO.setPoliticas(producto.getPoliticas());
        productoDTO.setCaracteristicas(producto.getCaracteristicas());
        return productoDTO;
    }

    private Producto productoDTOAProducto(ProductoDTO productoDTO){
        Producto producto = new Producto();
        Categoria categoria = new Categoria();
        Ciudad ciudad = new Ciudad();
        producto.setPoliticas(productoDTO.getPoliticas());
        ciudad.setId(productoDTO.getCiudadID());
        categoria.setId(productoDTO.getCategoriaID());
        producto.setId(productoDTO.getId());
        producto.setTitulo(productoDTO.getTitulo());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setCategoria(categoria);
        producto.setCiudad(ciudad);
        producto.setCaracteristicas(productoDTO.getCaracteristicas());
        return producto;
    }
}
