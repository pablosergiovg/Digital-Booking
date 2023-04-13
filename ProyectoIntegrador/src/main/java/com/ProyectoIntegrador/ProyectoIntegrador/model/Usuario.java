package com.ProyectoIntegrador.ProyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioId")
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;

    @Column(name = "password")
    private String password;

    @Column
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "rolId")
    private Rol rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "reserva_usuario")
    private Set<Reserva> reservas = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "favoritos",
            joinColumns = @JoinColumn(name = "UsuarioId"),
            inverseJoinColumns = @JoinColumn(name = "ProductoID"))
    private Set<Producto> favoritos = new HashSet<>();

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario(String nombre, String apellido, String email, String password, String ciudad, Rol rol, Set<Reserva> reservas, Set<Producto> favoritos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.ciudad = ciudad;
        this.rol = rol;
        this.reservas = reservas;
        this.favoritos = favoritos;
    }

    public Usuario(Long id, String nombre, String apellido, String email, String password, String ciudad, Rol rol, Set<Reserva> reservas, Set<Producto> favoritos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.ciudad = ciudad;
        this.rol = rol;
        this.reservas = reservas;
        this.favoritos = favoritos;
    }

    public Usuario() {
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
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

    public Set<Producto> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Set<Producto> favoritos) {
        this.favoritos = favoritos;
    }

    public void agregarFavorito(Producto producto) {
        this.favoritos.add(producto);
        producto.getFavoriteador().add(this);
    }

    public void quitarFavorito(Long productoId) {
        Producto productoFavoriteado = this.favoritos.stream().filter(t -> t.getId() == productoId).findFirst().orElse(null);
        if (productoFavoriteado != null) {
            this.favoritos.remove(productoFavoriteado);
            productoFavoriteado.getFavoriteador().remove(this);
        }
    }
}
