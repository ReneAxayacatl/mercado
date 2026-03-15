package com.rene.mercado.RestControlador;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rene.mercado.Modelo.Comida;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioComida;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("rene/api/Comida")
public class RestControladorComida {

    @Autowired
    private ImplementacionServicioComida comidaServicio;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Comida> traerCaduce(@NonNull @PathVariable("id") Integer id) {
        Optional<Comida> optComida = comidaServicio.buscarComidasPorId(id);
        if (optComida.isPresent()) {
            Comida comida = optComida.get();
            return ResponseEntity.ok(comida);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comida> agregarCaduce(@NonNull @Valid @RequestBody Comida comidas) {
        Comida comida = comidaServicio.guardarComidas(comidas);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(comida.getIdComida())
                .toUri();
        return ResponseEntity.created(location).body(comida);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comida> editarComida(@NonNull @Valid @RequestBody Comida comidas) {
        Comida comida = comidaServicio.editarComidas(comidas);
        Integer id = comida.getIdComida();
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        return comidaServicio.buscarComidasPorId(id)
                .map(iterarActualizar -> ResponseEntity.ok(comidaServicio.editarComidas(comida)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Comida> eliminarComida(@NonNull @PathVariable Integer id) {
        return comidaServicio.buscarComidasPorId(id)
                .map(iterarEliminacion -> {
                    comidaServicio.eliminarComidasPorId(id);
                    return ResponseEntity.ok(iterarEliminacion);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
