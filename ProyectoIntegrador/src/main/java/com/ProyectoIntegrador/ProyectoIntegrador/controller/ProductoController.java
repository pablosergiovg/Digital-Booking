package com.ProyectoIntegrador.ProyectoIntegrador.controller;

import com.ProyectoIntegrador.ProyectoIntegrador.exception.ResourceNotFoundException;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Producto;
import com.ProyectoIntegrador.ProyectoIntegrador.model.Usuario;
import com.ProyectoIntegrador.ProyectoIntegrador.repository.UsuarioRepository;
import com.ProyectoIntegrador.ProyectoIntegrador.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.Random;


    @RestController
    @RequestMapping("api/productos")
    @CrossOrigin("*")
public class ProductoController {

    private ProductoService productoService;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    public ProductoController(ProductoService productoService) { this.productoService = productoService; }

    @GetMapping
    public ResponseEntity<List<Producto>> buscarProductos(){
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Producto>> buscarProductoPorId(@PathVariable Long id){
        Optional<Producto> productoBuscado = productoService.buscarProductoXId(id);
        if (productoBuscado.isPresent()){
            return ResponseEntity.ok(productoBuscado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/random")
    public ResponseEntity<List<Producto>> buscarProductoRandom(){
        List<Producto> listaproductos  = productoService.listarProductos();
        List<Producto> listaProductosRandom = new ArrayList<>();
        Random random = new Random();
        Producto productoRandom1 = listaproductos.get(random.nextInt(listaproductos.size()));
        Producto productoRandom2 = listaproductos.get(random.nextInt(listaproductos.size()));
        Producto productoRandom3 = listaproductos.get(random.nextInt(listaproductos.size()));
        Producto productoRandom4 = listaproductos.get(random.nextInt(listaproductos.size()));
        Producto productoRandom5 = listaproductos.get(random.nextInt(listaproductos.size()));
        Producto productoRandom6 = listaproductos.get(random.nextInt(listaproductos.size()));
        Producto productoRandom7 = listaproductos.get(random.nextInt(listaproductos.size()));
        Producto productoRandom8 = listaproductos.get(random.nextInt(listaproductos.size()));
        listaProductosRandom.add(productoRandom1);
        listaProductosRandom.add(productoRandom2);
        listaProductosRandom.add(productoRandom3);
        listaProductosRandom.add(productoRandom4);
        listaProductosRandom.add(productoRandom5);
        listaProductosRandom.add(productoRandom6);
        listaProductosRandom.add(productoRandom7);
        listaProductosRandom.add(productoRandom8);
        return ResponseEntity.ok(listaProductosRandom);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Producto>> buscarProductoPorCategoria(@PathVariable String categoria){
        return ResponseEntity.ok(productoService.buscarProductoXCategoria(categoria));
    }
    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<List<Producto>> buscarProductoPorCiudad(@PathVariable String ciudad){
        return ResponseEntity.ok(productoService.buscarProductoXciudad(ciudad));
    }

    @GetMapping("/fechaCiudad")
    public ResponseEntity<List<Producto>> buscarProductosPorCiudadYFecha(@RequestParam(name = "fechaInicio") @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate fechaInicio, @RequestParam(name = "fechaFinal") @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate fechaFinal, @RequestParam(name = "idCiudad")Long idCiudad ){
        return ResponseEntity.ok(productoService.buscarProductosXCiudadYFecha(fechaInicio, fechaFinal, idCiudad));
    }

    @GetMapping("/favs/usuario/{usuarioId}")
    public ResponseEntity<List<Producto>> buscarFavoritosPorUsuarioId(@PathVariable Long usuarioId) throws ResourceNotFoundException {
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + usuarioId);
        }

        List<Producto> productosFavoriteados = productoService.buscarProductosFavoriteadosPorUsuarioId(usuarioId);
        return new ResponseEntity<>(productosFavoriteados, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.guardarProducto(producto));
    }

    @PostMapping("/favs/{usuarioId}")
    public ResponseEntity<Optional<Producto>> favoritearProducto(@PathVariable Long usuarioId, @RequestBody Producto productoRequest){
        Optional<Producto> producto = usuarioRepository.findById(usuarioId).map(usuario -> {
            Long productoId = productoRequest.getId();
            if (productoId != 0L){
                if(productoService.buscarProductoXId(productoId).isPresent()){
                    Producto productoBuscado = productoService.buscarProductoXId(productoId).get();
                    usuario.agregarFavorito(productoBuscado);
                    usuarioRepository.save(usuario);
                    return productoBuscado;
                }
            }
            usuario.agregarFavorito(productoRequest);
            return productoService.guardarProducto(productoRequest);
        });
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> actualizarProducto(@RequestBody Producto producto){
        Optional<Producto> productoBuscado = productoService.buscarProductoXId(producto.getId());
        if (productoBuscado.isPresent()){
            productoService.actualizarProducto(producto);
            return ResponseEntity.ok("Se actualizó el producto con Id: " + producto.getId());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar el producto con id: " + producto.getId() + ", verificar si existe ese producto en la base de datos.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarProducto(@PathVariable Long id){
        Optional<Producto> productoBuscado = productoService.buscarProductoXId(id);
        if (productoBuscado.isPresent()){
            productoService.eliminarProducto(id);
            return ResponseEntity.ok("Se eliminó el producto con Id: " + id);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo borrar el producto con id: " + id + ", verificar si existe ese producto en la base de datos.");
        }
    }

        @DeleteMapping("/favs/{usuarioId}/prod/{productoId}")
        public ResponseEntity<HttpStatus> quitarProductoDeFavoritos(@PathVariable(value = "usuarioId") Long usuarioId, @PathVariable(value = "productoId") Long productoId) throws ResourceNotFoundException {
            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + usuarioId));

            usuario.quitarFavorito(productoId);
            usuarioRepository.save(usuario);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
