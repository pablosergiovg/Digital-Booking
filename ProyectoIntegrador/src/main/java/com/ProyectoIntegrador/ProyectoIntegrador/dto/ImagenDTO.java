package com.ProyectoIntegrador.ProyectoIntegrador.dto;

public class ImagenDTO {
    private Long id;
    private String titulo;
    private String urlImagen;
    private Long productoId;

    public ImagenDTO() {
    }

    public ImagenDTO(String titulo, String urlImagen, Long productoId) {
        this.titulo = titulo;
        this.urlImagen = urlImagen;
        this.productoId = productoId;
    }

    public ImagenDTO(Long id, String titulo, String urlImagen, Long productoId) {
        this.id = id;
        this.titulo = titulo;
        this.urlImagen = urlImagen;
        this.productoId = productoId;
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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }
}
