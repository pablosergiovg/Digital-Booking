package com.ProyectoIntegrador.ProyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductoID")
    private Long id;
    @Column(name = "nombre")
    private String titulo;
    @Column
    private String descripcion;
    @Column
    private String direccion;
    @Column(name = "PrecioPorDia")
    private Double precio;
    @Column
    private Integer puntuacion;
    @Column
    private Integer clasificacion;
    @Column
    private Double latitud;
    @Column
    private Double longitud;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "CategoriaID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "CiudadID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Ciudad ciudad;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name="productos_politicas",
            joinColumns = @JoinColumn(name = "IDProducto"),
            inverseJoinColumns = @JoinColumn(name = "IDPolitica"))
    private Set<Politica> politicas = new HashSet<>();
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Imagen> imagenes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "productos_caracteristicas",
            joinColumns = @JoinColumn(name = "ProductoID"),
            inverseJoinColumns = @JoinColumn(name = "CaracteristicaID"))
    private Set<Caracteristica> caracteristicas = new HashSet<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonManagedReference(value = "producto_reservas")
    private Set<Reserva> reservas = new HashSet<>();

    @ManyToMany(mappedBy = "favoritos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Usuario> favoriteador = new HashSet<>();

    public Producto() {
    }

    public Producto(String titulo, String descripcion, String direccion, Double precio, Integer puntuacion, Integer clasificacion, Double latitud, Double longitud, Categoria categoria, Ciudad ciudad, Set<Politica> politicas, Set<Imagen> imagenes, Set<Caracteristica> caracteristicas, Set<Reserva> reservas, Set<Usuario> favoriteador) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.precio = precio;
        this.puntuacion = puntuacion;
        this.clasificacion = clasificacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.categoria = categoria;
        this.ciudad = ciudad;
        this.politicas = politicas;
        this.imagenes = imagenes;
        this.caracteristicas = caracteristicas;
        this.reservas = reservas;
        this.favoriteador = favoriteador;
    }

    public Producto(Long id, String titulo, String descripcion, String direccion, Double precio, Integer puntuacion, Integer clasificacion, Double latitud, Double longitud, Categoria categoria, Ciudad ciudad, Set<Politica> politicas, Set<Imagen> imagenes, Set<Caracteristica> caracteristicas, Set<Reserva> reservas, Set<Usuario> favoriteador) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.precio = precio;
        this.puntuacion = puntuacion;
        this.clasificacion = clasificacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.categoria = categoria;
        this.ciudad = ciudad;
        this.politicas = politicas;
        this.imagenes = imagenes;
        this.caracteristicas = caracteristicas;
        this.reservas = reservas;
        this.favoriteador = favoriteador;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Integer clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Set<Politica> getPoliticas() {
        return politicas;
    }

    public void setPoliticas(Set<Politica> politicas) {
        this.politicas = politicas;
    }

    public Set<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(Set<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Set<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addImagen(Imagen imagen){
        imagenes.add(imagen);
        imagen.setProducto(this);
    }

    public void removeImagen(Imagen imagen){
        imagenes.remove(imagen);
        imagen.setProducto(this);
    }

    public Set<Usuario> getFavoriteador() {
        return favoriteador;
    }

    public void setFavoriteador(Set<Usuario> favoriteador) {
        this.favoriteador = favoriteador;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", precio=" + precio +
                ", puntuacion=" + puntuacion +
                ", clasificacion=" + clasificacion +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", categoria=" + categoria +
                ", ciudad=" + ciudad +
                ", politicas=" + politicas +
                ", imagenes=" + imagenes +
                ", caracteristicas=" + caracteristicas +
                ", reservas=" + reservas +
                '}';
    }
}
