package com.rene.mercado.Controlador;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;

import com.rene.mercado.Modelo.Talla;
import com.rene.mercado.Servicio.ServicioTalla;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
  private ServicioTalla tallasService;

  // @GetMapping(path = TALLAS_ENDPOINT)
  // public String tallas() {
  // return "tallas";
  // }
  @GetMapping(path = TALLAS_ENDPOINT + "/{id}")
  public ResponseEntity<Talla> traerTallas(@NonNull @PathVariable("id") Integer id) {
    Optional<Talla> optTallas = tallasService.buscarTallaPorId(id);
    if (optTallas.isPresent()) {
      Talla tallas = optTallas.get();
      return ResponseEntity.ok(tallas);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping(path = TALLAS_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Talla> agregarTallas(@NonNull @Valid @RequestBody Talla tallas) {
    Talla talla = tallasService.guardarTallas(tallas);
    return ResponseEntity
        .created(URI.create("/rene/Tallas" + talla.getIdTalla()))
        .body(talla);
  }

  @PutMapping(path = TALLAS_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Talla> editarTallas(@NonNull @Valid @RequestBody Talla tallas) {
    Talla talla = tallasService.editarTallas(tallas);
    Integer id = talla.getIdTalla();
    if (id == null) {
      return ResponseEntity.badRequest().build();
    }
    return tallasService.buscarTallaPorId(id)
        .map(c -> ResponseEntity.ok(tallasService.editarTallas(talla)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping(path = TALLAS_ENDPOINT + "/{id}")
  public ResponseEntity<Talla> eliminarTallas(@NonNull @PathVariable("id") Integer id) {
    return tallasService.buscarTallaPorId(id)
        .map(iterarEliminacion -> {
          tallasService.eliminarTallasPorId(id);
          return ResponseEntity.ok(iterarEliminacion);
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
