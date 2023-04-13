package com.ProyectoIntegrador.ProyectoIntegrador.service;

import com.ProyectoIntegrador.ProyectoIntegrador.dto.ReservaDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.dto.UsuarioDTO;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Producto;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Reserva;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Usuario;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.ProductoRepository;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) { this.usuarioRepository = usuarioRepository; }

    public List<UsuarioDTO> listarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> respuesta = new ArrayList<>();
            for (Usuario usuario : usuarios ){
                respuesta.add(usuarioAUsuarioDTO(usuario));
            }
        return respuesta;
    }

    public Optional<UsuarioDTO> buscarUsuarioXId(Long id) {
        Optional<Usuario> usuarioEncontrado= usuarioRepository.findById(id);
        if (usuarioEncontrado.isPresent()){
            return Optional.of(usuarioAUsuarioDTO(usuarioEncontrado.get()));
        } else {
            return Optional.empty();
        }
    }
    public Optional<UsuarioDTO> buscarUsuarioXEmail(String email) {
        Usuario usuarioEncontrado= usuarioRepository.findByEmail(email);
        if (usuarioEncontrado != null){
            return  Optional.of(usuarioAUsuarioDTO(usuarioEncontrado));
        } else {
            return Optional.empty();
        }
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioAGuardar = usuarioDTOAUsuario(usuarioDTO);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        usuarioAGuardar.setPassword(bCryptPasswordEncoder.encode(usuarioAGuardar.getPassword()));
        Usuario usuarioGuardaro = usuarioRepository.save(usuarioAGuardar);
        return usuarioAUsuarioDTO(usuarioGuardaro);
    }

    public void actualizarUsuario(Usuario usuario){ usuarioRepository.save(usuario); }

    public void eliminarUsuario(Long id){ usuarioRepository.deleteById(id); }


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


    private Usuario usuarioDTOAUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        Set<Reserva> reservas = new HashSet<>();
        for(ReservaDTO reservaDTO : usuarioDTO.getReservas()){
         reservas.add(reservaDTOAReserva(reservaDTO));
        }

        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setCiudad(usuarioDTO.getCiudad());
        usuario.setRol(usuarioDTO.getRol());
        usuario.setReservas(reservas);
        return usuario;
    }

    private UsuarioDTO usuarioAUsuarioDTO(Usuario usuario){
        Set<ReservaDTO> reservasDTO = new HashSet<>();

        for(Reserva reserva : usuario.getReservas()){
            reservasDTO.add(reservaAReservaDTO(reserva));
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setApellido(usuario.getApellido());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setCiudad(usuario.getCiudad());
        usuarioDTO.setRol(usuario.getRol());
        usuarioDTO.setReservas(reservasDTO);
//        System.out.println(reservaAReservaDTO(usuario.getReservas()).toString());
        return usuarioDTO;
    }
}
