package com.ProyectoIntegrador.ProyectoIntegrador.repository;

import com.ProyectoIntegrador.ProyectoIntegrador.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query(value = "select p from Producto p where upper(p.categoria.titulo) like upper(?1)")
    List<Producto> filtrarPorCategoria(String titulo);

    @Query("select p from Producto p where upper(p.ciudad.nombre) = upper(?1)")
    List<Producto> filtrarPorCiudad(String nombre);

    @Query(value = "select * from productos where ciudadId = :idCiudad and " +
            "ProductoId not in(select ProductoID from reservas where(FechaInicio < :fechaInicio and FechaFinal > :fechaFinal) or " +
            "(FechaInicio between :fechaInicio and :fechaFinal) or (FechaFinal between :fechaInicio and :fechaFinal))", nativeQuery = true)
    List<Producto> filtrarPorCiudadYFecha(LocalDate fechaInicio, LocalDate fechaFinal, Long idCiudad);

    @Query(value = "SELECT productos.* FROM productos \n" +
            "inner join favoritos on productos.ProductoID = favoritos.ProductoID\n" +
            "where favoritos.UsuarioId = :id",nativeQuery = true)
    List<Producto> findProductoByUsuarioId(Long id);
}
