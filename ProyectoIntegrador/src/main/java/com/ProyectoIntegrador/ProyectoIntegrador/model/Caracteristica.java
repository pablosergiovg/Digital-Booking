package com.ProyectoIntegrador.ProyectoIntegrador.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "caracteristicas")
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CaracteristicaID")
    private Long id;
    @Column(name = "titulo")
    private String nombre;
    @Column(name = "icono")
    private String icono;

    @ManyToMany(mappedBy = "caracteristicas")
    private Set<Producto> productos = new HashSet<>();

    public Caracteristica(Long id, String nombre, String icono) {
        this.id = id;
        this.nombre = nombre;
        this.icono = icono;
    }

    public Caracteristica(String nombre, String icono) {
        this.nombre = nombre;
        this.icono = icono;
    }

    public Caracteristica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "Caracteristica{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", icono='" + icono + '\'' +
                ", productos=" + productos +
                '}';
    }
}
