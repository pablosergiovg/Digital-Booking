package com.ProyectoIntegrador.ProyectoIntegrador.dto;

import com.ProyectoIntegrador.ProyectoIntegrador.model.Caracteristica;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Politica;

import java.util.HashSet;
import java.util.Set;

public class ProductoDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private Long categoriaID;
    private Long ciudadID;
    private Set<Politica> politicas = new HashSet<>();
    private Set<Caracteristica> caracteristicas = new HashSet<>();

    public ProductoDTO() {
    }

    public ProductoDTO(String titulo, String descripcion, Long categoriaID, Long ciudadID, Set<Politica> politicas, Set<Caracteristica> caracteristicas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoriaID = categoriaID;
        this.ciudadID = ciudadID;
        this.politicas = politicas;
        this.caracteristicas = caracteristicas;
    }

    public ProductoDTO(Long id, String titulo, String descripcion, Long categoriaID, Long ciudadID, Set<Politica> politicas, Set<Caracteristica> caracteristicas) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoriaID = categoriaID;
        this.ciudadID = ciudadID;
        this.politicas = politicas;
        this.caracteristicas = caracteristicas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(Long categoriaID) {
        this.categoriaID = categoriaID;
    }

    public Long getCiudadID() {
        return ciudadID;
    }

    public void setCiudadID(Long ciudadID) {
        this.ciudadID = ciudadID;
    }

    public Set<Politica> getPoliticas() {
        return politicas;
    }

    public void setPoliticas(Set<Politica> politicaDTOS) {
        this.politicas = politicaDTOS;
    }

    public Set<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
