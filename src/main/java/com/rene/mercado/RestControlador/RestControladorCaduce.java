package com.rene.mercado.Controlador;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioCaduce;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", methods = {
    RequestMethod.GET,
    RequestMethod.POST,
    RequestMethod.DELETE,
    RequestMethod.PUT,
})
@RequestMapping("/Caduce")
public class RestControladorCaduce {

    // public static final String CADUCE_ENDPOINT = "/rene/caduce";

    @Autowired
    private ImplementacionServicioCaduce caduceService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Caduce> traerCaduce(@PathVariable("id") Integer id) {
        Optional<Caduce> optCaduce = caduceService.buscarCaducePorId(id);
        if (optCaduce.isPresent()) {
            Caduce caduce = optCaduce.get();
            return ResponseEntity.ok(caduce);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Caduce> agregarCaduce(@Valid @RequestBody Caduce caduca) {
        Caduce caduce = caduceService.guardarCaduce(caduca);
        return ResponseEntity
                .created(URI.create("/Caduce" + caduce.getIdCaduce()))
                .body(caduce);
        // URI location = URI.create(CADUCE_ENDPOINT + "/" + caduce.getIdCaduce());
        // return ResponseEntity.created(location).body(caduce);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Caduce> editarCaduce(
            @Valid @RequestBody Caduce caduca) {
        Caduce caduce = caduceService.editarCaduce(caduca);
        return caduceService.buscarCaducePorId(caduce.getIdCaduce())
                .map(iterarActualizar -> ResponseEntity.ok(caduceService.editarCaduce(caduce)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Caduce> eliminarCaduce(
            @PathVariable("id") Integer id) {
        return caduceService.buscarCaducePorId(id)
                .map(iterarEliminacion -> {
                    caduceService.eliminarCaducePorId(id);
                    return ResponseEntity.ok(iterarEliminacion);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
