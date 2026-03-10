package com.rene.mercado.controller;

import java.net.URI;
import java.util.Optional;

import org.hibernate.result.Outputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rene.mercado.model.Talla;
import com.rene.mercado.service.ITallaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(origins = "*", methods = {
    RequestMethod.GET,
    RequestMethod.POST,
    RequestMethod.DELETE,
    RequestMethod.PUT,
})

public class TallaController {

  public static final String TALLAS_ENDPOINT = "/rene/tallas";

  @Autowired
  private ITallaService tallasService;

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
  public ResponseEntity<Talla> addTallas(@Validated @RequestBody Talla tallas) {
    Talla talla = tallasService.saveTallas(tallas);
    return ResponseEntity
        .created(URI.create("/rene/tallas" + talla.getIdTalla()))
        .body(talla);
  }

}
