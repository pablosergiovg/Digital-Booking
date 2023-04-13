package com.ProyectoIntegrador.ProyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoriaID")
    private Long id;
    @Column
    private String titulo;
    @Column
    private String descripcion;
    @Column(name = "url_imagen")
    private String urlImagen;
    @OneToMany(mappedBy = "categoria")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Producto> productos = new HashSet<>();
    public Categoria (){
    }

    public Categoria(String titulo, String descripcion, String urlImagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public Categoria(Long id, String titulo, String descripcion, String urlImagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        System.out.println(id);
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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", urlImagen='" + urlImagen + '\'' +
                ", productos=" + productos +
                '}';
    }
}
