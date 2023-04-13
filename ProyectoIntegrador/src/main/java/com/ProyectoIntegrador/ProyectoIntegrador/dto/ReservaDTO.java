package com.ProyectoIntegrador.ProyectoIntegrador.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {
    private Long id;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private LocalTime horaInicio;
    private Long productoId;
    private Long usuarioId;

    public ReservaDTO() {
    }

    public ReservaDTO(LocalDate fechaInicial, LocalDate fechaFinal, LocalTime horaInicio, Long productoId, Long usuarioId) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.horaInicio = horaInicio;
        this.productoId = productoId;
        this.usuarioId = usuarioId;
    }

    public ReservaDTO(Long id, LocalDate fechaInicial, LocalDate fechaFinal, LocalTime horaInicio, Long productoId, Long usuarioId) {
        this.id = id;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.horaInicio = horaInicio;
        this.productoId = productoId;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
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

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "ReservaDTO{" +
                "id=" + id +
                ", fechaInicial=" + fechaInicial +
                ", fechaFinal=" + fechaFinal +
                ", horaInicio=" + horaInicio +
                ", productoId=" + productoId +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
