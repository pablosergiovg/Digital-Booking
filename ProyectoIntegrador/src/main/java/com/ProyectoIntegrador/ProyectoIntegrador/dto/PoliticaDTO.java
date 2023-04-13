package com.ProyectoIntegrador.ProyectoIntegrador.dto;

public class PoliticaDTO {
    private Long id;
    private String titulo;
    private String detalle;

    public PoliticaDTO() {
    }

    public PoliticaDTO(String titulo, String detalle) {
        this.titulo = titulo;
        this.detalle = detalle;
    }

    public PoliticaDTO(Long id, String titulo, String detalle) {
        this.id = id;
        this.titulo = titulo;
        this.detalle = detalle;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
