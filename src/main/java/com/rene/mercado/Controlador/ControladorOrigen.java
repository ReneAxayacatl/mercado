package com.rene.mercado.Controlador;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Modelo.Origen;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioOrigen;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/Origen")
public class ControladorOrigen {

    @Autowired
    private ImplementacionServicioOrigen origenServicio;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Origen> traerOirgen(@PathVariable Integer id) {
        Optional<Origen> optOrigen = origenServicio.buscarOrigenPorId(id);
        if (optOrigen.isPresent()) {
            Origen origen = optOrigen.get();
            return ResponseEntity.ok(origen);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Origen> agregarCaduce(@Valid @RequestBody Origen origenes) {
        Origen origen = origenServicio.guardarOrigen(origenes);
        return ResponseEntity
                .created(URI.create("/Caduce" + origen.getIdOrigen()))
                .body(origen);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Origen> agregarOrigen(@Valid @RequestBody Origen origenes) {
        Origen origen = origenServicio.editarOrigen(origenes);
        return origenServicio.buscarOrigenPorId(origen.getIdOrigen())
                .map((iterarActualizar -> ResponseEntity.ok(origenServicio.editarOrigen(origen))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Origen> eliminarOrigen(@PathVariable Integer id) {
        return origenServicio.buscarOrigenPorId(id).map(iterarEliminacion -> {
            origenServicio.eliminarOrigenPorId(id);
            return ResponseEntity.ok(iterarEliminacion);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
