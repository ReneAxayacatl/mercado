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

import com.rene.mercado.Modelo.Ropa;
import com.rene.mercado.Servicio.ServicioRopa;

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
@RequestMapping("rene/api/Ropa")
public class RestControladorRopa {

    @Autowired
    private ServicioRopa ropaServicio;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Ropa> traerCaduce(@NonNull @PathVariable Integer id) {
        Optional<Ropa> optRopa = ropaServicio.buscarRopasPorId(id);
        if (optRopa.isPresent()) {
            Ropa ropa = optRopa.get();
            return ResponseEntity.ok(ropa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ropa> agregarRopa(@NonNull @Valid @RequestBody Ropa ropas) {
        Ropa ropa = ropaServicio.guardarRopas(ropas);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(ropa.getIdRopa())
                .toUri();
        return ResponseEntity.created(location).body(ropa);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ropa> editarRopa(@NonNull @Valid @RequestBody Ropa ropas) {
        Ropa ropa = ropaServicio.editarRopas(ropas);
        Integer id = ropa.getIdRopa();
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        return ropaServicio.buscarRopasPorId(id)
                .map(iterarActualizar -> ResponseEntity.ok(ropaServicio.editarRopas(ropa)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Ropa> eliminarRopa(@NonNull @PathVariable Integer id) {
        return ropaServicio.buscarRopasPorId(id)
                .map(iterarEliminacion -> {
                    ropaServicio.eliminarRopasPorId(id);
                    return ResponseEntity.ok(iterarEliminacion);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
