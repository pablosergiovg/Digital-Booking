package com.ProyectoIntegrador.ProyectoIntegrador.dto;

public class CategoriaDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private String urlimagen;


    public CategoriaDTO(){
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

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public CategoriaDTO(Long id, String titulo, String descripcion, String urlimagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlimagen = urlimagen;
    }

    public CategoriaDTO(String titulo, String descripcion, String urlimagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlimagen = urlimagen;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", urlimagen='" + urlimagen + '\'' +
                '}';
    }
}
