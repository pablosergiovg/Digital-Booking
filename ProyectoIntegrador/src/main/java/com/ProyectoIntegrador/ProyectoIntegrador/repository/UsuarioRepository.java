package com.ProyectoIntegrador.ProyectoIntegrador.repository;

import com.ProyectoIntegrador.ProyectoIntegrador.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByNombre(String nombre);

    public Usuario findByEmail(String email);

//    public List<Usuario> findUsuarioByProductoId(Long productoId);

    @Query(value = "SELECT * FROM proyecto_test.favoritos where ProductoID = :id", nativeQuery = true)
    List<Usuario> buscarProductosFavoriteadosPorIdUsaurio(Long id);

}
