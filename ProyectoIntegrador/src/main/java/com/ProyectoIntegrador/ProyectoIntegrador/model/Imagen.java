package com.ProyectoIntegrador.ProyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ImagenID")
    private Long id;
    @Column
    private String titulo;
    @Column(name = "url")
    private String urlImagen;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductoID")
    @JsonBackReference
    private Producto producto;

    public Imagen(Long id, String titulo, String urlImagen) {
        this.id = id;
        this.titulo = titulo;
        this.urlImagen = urlImagen;
    }

    public Imagen(String titulo, String urlImagen) {
        this.titulo = titulo;
        this.urlImagen = urlImagen;
    }

    public Imagen() {
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

    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Imagen{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", urlImagen='" + urlImagen + '\'' +
                ", producto=" + producto +
                '}';
    }
}
