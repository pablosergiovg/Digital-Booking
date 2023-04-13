package com.ProyectoIntegrador.ProyectoIntegrador.dto;

import com.ProyectoIntegrador.ProyectoIntegrador.model.Reserva;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Rol;

import java.util.HashSet;
import java.util.Set;

public class UsuarioDTO {
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String password;

    private String ciudad;

    private Rol rol;

    private Set<ReservaDTO> reservas = new HashSet<>();

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombre, String apellido, String email, String password, String ciudad, Rol rol, Set<ReservaDTO> reservas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.ciudad = ciudad;
        this.rol = rol;
        this.reservas = reservas;
    }

    public UsuarioDTO(Long id, String nombre, String apellido, String email, String password, String ciudad, Rol rol, Set<ReservaDTO> reservas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.ciudad = ciudad;
        this.rol = rol;
        this.reservas = reservas;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Set<ReservaDTO> getReservas() {
        return reservas;
    }

    public void setReservas(Set<ReservaDTO> reservas) {
        this.reservas = reservas;
    }
}
