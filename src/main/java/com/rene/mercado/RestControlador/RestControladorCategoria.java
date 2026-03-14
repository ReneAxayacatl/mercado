package com.rene.mercado.RestControlador;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rene.mercado.Modelo.Categoria;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioCategoria;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("api/Categoria")
public class RestControladorCategoria {

    @Autowired
    private ImplementacionServicioCategoria categoriaService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Categoria> traerCategoria(@PathVariable("id") Integer id) {
        Optional<Categoria> optCategoria = categoriaService.buscarCategoriasPorId(id);
        if (optCategoria.isPresent()) {
            Categoria categoria = optCategoria.get();
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> agregarCategoria(@Valid @RequestBody Categoria categorias) {
        Categoria categoria = categoriaService.guardarCategorias(categorias);
        return ResponseEntity
                .created(URI.create("api/Categoria" + categoria.getIdCategoria()))
                .body(categoria);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> editarCaduce(
            @Valid @RequestBody Categoria categorias) {
        Categoria categoria = categoriaService.editarCategorias(categorias);
        return categoriaService.buscarCategoriasPorId(categoria.getIdCategoria())
                .map(iterarActualizar -> ResponseEntity.ok(categoriaService.editarCategorias(categoria)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Categoria> eliminarCaduce(
            @PathVariable("id") Integer id) {
        return categoriaService.buscarCategoriasPorId(id)
                .map(iterarEliminacion -> {
                    categoriaService.eliminarCategoriasPorId(id);
                    return ResponseEntity.ok(iterarEliminacion);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
