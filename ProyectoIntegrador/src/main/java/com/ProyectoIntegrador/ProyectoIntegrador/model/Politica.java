package com.ProyectoIntegrador.ProyectoIntegrador.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "politicas")
public class Politica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PoliticaID")
    private Long id;
    @Column
    private String titulo;
    @Column(name = "descripcion")
    private String detalle;

//    checkear
    @ManyToMany(mappedBy = "politicas")
    private Set<Producto> productos = new HashSet<>();

    public Politica(Long id, String titulo, String detalle) {
        this.id = id;
        this.titulo = titulo;
        this.detalle = detalle;
    }

    public Politica(String titulo, String detalle) {
        this.titulo = titulo;
        this.detalle= detalle;
    }

    public Politica() {
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

    @Override
    public String toString() {
        return "Politica{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", detalle='" + detalle + '\'' +
                ", productos=" + productos +
                '}';
    }
}
