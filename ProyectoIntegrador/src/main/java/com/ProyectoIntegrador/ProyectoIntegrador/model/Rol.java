package com.ProyectoIntegrador.ProyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rolId")
    private Long id;

    @Column(name = "Tipo")
    private String tipo;

    @JsonIgnore
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Usuario> usuarios = new HashSet<>();

    public Rol(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Rol(String tipo) {
        this.tipo = tipo;
    }

    public Rol() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
