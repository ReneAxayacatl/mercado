package com.rene.mercado.Controlador;

import java.net.URI;
import java.util.Optional;

import org.hibernate.result.Outputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.*; 
import jakarta.validation.Valid;

import com.rene.mercado.Modelo.Talla;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioTalla;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
// @RestController
@CrossOrigin(origins = "*", methods = {
    RequestMethod.GET,
    RequestMethod.POST,
    RequestMethod.DELETE,
    RequestMethod.PUT,
})

public class ControladorTalla {

  public static final String TALLAS_ENDPOINT = "/rene/tallas";

  @Autowired
  private ImplementacionServicioTalla tallasService;

  @GetMapping(path = TALLAS_ENDPOINT + "/{id}")
  public ResponseEntity<Talla> getTallas(@PathVariable("id") Integer id) {
    Optional<Talla> optTallas = tallasService.searchTallaById(id);
    if (optTallas.isPresent()) {
      Talla tallas = optTallas.get();
      return ResponseEntity.ok(tallas);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping(path = TALLAS_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Talla> addTallas(@Valid @RequestBody Talla tallas) {
    Talla talla = tallasService.saveTallas(tallas);
    return ResponseEntity
        .created(URI.create("/rene/tallas" + talla.getIdTalla()))
        .body(talla);
        // URI location = URI.create(TALLAS_ENDPOINT + "/" + talla.getIdTalla());
        // return ResponseEntity.created(location).body(talla);
  }

}
