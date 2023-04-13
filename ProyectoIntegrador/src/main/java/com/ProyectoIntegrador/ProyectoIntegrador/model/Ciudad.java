package com.ProyectoIntegrador.ProyectoIntegrador.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ciudades")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CiudadID")
    private Long id;
    @Column
    private String nombre;
    @Column
    private String provincia;
    @Column
    private String pais;
    @OneToMany(mappedBy = "ciudad")
    private Set<Producto> productos;

    public Ciudad(Long id, String nombre, String provincia, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.pais = pais;
    }

    public Ciudad(String nombre, String provincia, String pais) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.pais = pais;
    }

    public Ciudad() {
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                ", productos=" + productos +
                '}';
    }
}
