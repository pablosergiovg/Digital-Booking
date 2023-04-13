package com.ProyectoIntegrador.ProyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReservaID")
    private Long id;
    @Column
    private LocalDate fechaInicio;
    @Column
    private LocalDate fechaFinal;
    @Column
    private LocalTime horaInicio;

    @Column
    private Boolean vacunadoCovid;

    @Column
    private String datosExtra;

    @ManyToOne
    @JsonBackReference(value = "producto_reservas")
    @JoinColumn(name = "ProductoID", referencedColumnName = "ProductoID")
    private Producto producto;
    @ManyToOne
    @JsonBackReference(value = "reserva_usuario")
    @JoinColumn(name = "UsuarioID", referencedColumnName = "UsuarioId")
    private Usuario usuario;

    public Reserva(){
    }

    public Reserva(LocalDate fechaInicio, LocalDate fechaFinal, LocalTime horaInicio, Producto producto, Usuario usuario) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horaInicio = horaInicio;
        this.producto = producto;
        this.usuario = usuario;
    }

    public Reserva(Long id, LocalDate fechaInicio, LocalDate fechaFinal, LocalTime horaInicio, Producto producto, Usuario usuario) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horaInicio = horaInicio;
        this.producto = producto;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getVacunadoCovid() {
        return vacunadoCovid;
    }

    public void setVacunadoCovid(Boolean vacunadoCovid) {
        this.vacunadoCovid = vacunadoCovid;
    }

    public String getDatosExtra() {
        return datosExtra;
    }

    public void setDatosExtra(String datosExtra) {
        this.datosExtra = datosExtra;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", horaInicio=" + horaInicio +
                ", vacunadoCovid=" + vacunadoCovid +
                ", datosExtra='" + datosExtra + '\'' +
                ", producto=" + producto +
                ", usuario=" + usuario +
                '}';
    }
}