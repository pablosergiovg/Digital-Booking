package com.ProyectoIntegrador.ProyectoIntegrador.service;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.ReservaDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Producto;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Reserva;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Usuario;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.ProductoRepository;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private ReservaRepository reservaRepository;
    @Autowired
    public ReservaService(ReservaRepository reservaRepository) { this.reservaRepository = reservaRepository; }

    public List<ReservaDTO> listarReservas() {
        List<Reserva> reservasEncontradas = reservaRepository.findAll();
        List<ReservaDTO> respuesta = new ArrayList<>();
        for (Reserva reserva : reservasEncontradas) {
            respuesta.add(reservaAReservaDTO(reserva));
        }
        return respuesta;
    }

    public Optional<ReservaDTO> buscarReservaXId(Long id) {
        Optional<Reserva> reservaEncontrada = reservaRepository.findById(id);
        if (reservaEncontrada.isPresent()){
            return Optional.of(reservaAReservaDTO(reservaEncontrada.get()));
        } else {
            return Optional.empty();
        }
    }

    public List<ReservaDTO> buscarReservaXIdProducto(Long idProducto){
        List<Reserva> listaReservasEncontradas = reservaRepository.findReservaByIdProducto(idProducto);
        List<ReservaDTO> respuesta = new ArrayList<>();
        listaReservasEncontradas.forEach(res -> respuesta.add(reservaAReservaDTO(res)));
        return respuesta;
    }

    public List<ReservaDTO> buscarReservaXIdUsuario(Long idUsuario){
        List<Reserva> listaReservasEncontradas = reservaRepository.findByReserva_Usuario_Id(idUsuario);
        List<ReservaDTO> respuesta = new ArrayList<>();
        listaReservasEncontradas.forEach(res -> respuesta.add(reservaAReservaDTO(res)));
        return respuesta;
    }

    public ReservaDTO guardarReserva(ReservaDTO reservaDTO)    {
        Reserva reservaAGuardar = reservaDTOAReserva(reservaDTO);
        Reserva reservaGuardada = reservaRepository.save(reservaAGuardar);
        return reservaAReservaDTO(reservaGuardada);

    }

    public void actualizarReserva(ReservaDTO reservaDTO){
        Reserva reservaAActualizar = reservaDTOAReserva(reservaDTO);
        reservaRepository.save(reservaAActualizar);
    }

    public void elminarReserva(Long id){
        reservaRepository.deleteById(id);
    }

    private Reserva reservaDTOAReserva(ReservaDTO reservaDTO){
        Reserva reserva = new Reserva();
        Producto producto = new Producto();
        Usuario usuario = new Usuario();
        reserva.setFechaInicio(reservaDTO.getFechaInicial());
        reserva.setFechaFinal(reservaDTO.getFechaFinal());
        reserva.setHoraInicio(reservaDTO.getHoraInicio());
        reserva.setId(reservaDTO.getId());
        producto.setId(reservaDTO.getProductoId());
        usuario.setId(reservaDTO.getUsuarioId());
        reserva.setProducto(producto);
        reserva.setUsuario(usuario);
        return reserva;
    }

    private ReservaDTO reservaAReservaDTO(Reserva reserva){
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(reserva.getId());
        reservaDTO.setFechaInicial(reserva.getFechaInicio());
        reservaDTO.setFechaFinal(reserva.getFechaFinal());
        reservaDTO.setHoraInicio(reserva.getHoraInicio());
        reservaDTO.setProductoId(reserva.getProducto().getId());
        reservaDTO.setUsuarioId(reserva.getUsuario().getId());
        return reservaDTO;
    }
}
