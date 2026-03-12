package com.rene.mercado.Controlador;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.rene.mercado.Modelo.Talla;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioTalla;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RestController
@CrossOrigin(origins = "*", methods = {
    RequestMethod.GET,
    RequestMethod.POST,
    RequestMethod.DELETE,
    RequestMethod.PUT,
})
// @RequestMapping("/Talla")
public class ControladorTalla {

  public static final String TALLAS_ENDPOINT = "rene/Tallas";

  @Autowired
  private ImplementacionServicioTalla tallasService;

  @GetMapping(path = TALLAS_ENDPOINT + "/{id}")
  public ResponseEntity<Talla> traerTallas(@PathVariable("id") Integer id) {
    Optional<Talla> optTallas = tallasService.buscarTallaPorId(id);
    if (optTallas.isPresent()) {
      Talla tallas = optTallas.get();
      return ResponseEntity.ok(tallas);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping(path = TALLAS_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Talla> agregarTallas(@Valid @RequestBody Talla tallas) {
    Talla talla = tallasService.guardarTallas(tallas);
    return ResponseEntity
        .created(URI.create("/rene/Tallas" + talla.getIdTalla()))
        .body(talla);
        // URI location = URI.create(TALLAS_ENDPOINT + "/" + talla.getIdTalla());
        // return ResponseEntity.created(location).body(talla);
  }

  @PutMapping(path = TALLAS_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Talla> editarTallas(
      @Valid @RequestBody Talla tallas) {
    Talla talla = tallasService.editarTallas(tallas);
    return tallasService.buscarTallaPorId(talla.getIdTalla())
        .map(c -> ResponseEntity.ok(tallasService.editarTallas(talla)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping(path = TALLAS_ENDPOINT + "/{id}")
  public ResponseEntity<Talla> eliminarTallas(
      @PathVariable("id") Integer id) {
    return tallasService.buscarTallaPorId(id)
        .map(iterarEliminacion -> {
          tallasService.eliminarTallasPorId(id);
          return ResponseEntity.ok(iterarEliminacion);
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
