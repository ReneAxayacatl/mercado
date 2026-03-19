// package com.rene.mercado.RestControlador;

// import java.net.URI;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.lang.NonNull;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import com.rene.mercado.Modelo.Origen;
// import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioOrigen;

// import jakarta.validation.Valid;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PutMapping;

// @RestController
// @CrossOrigin(origins = "*", methods = {
//         RequestMethod.GET,
//         RequestMethod.POST,
//         RequestMethod.DELETE,
//         RequestMethod.PUT,
// })
// @RequestMapping("rene/api/Origen")
// public class RestControladorOrigen {

//     @Autowired
//     private ImplementacionServicioOrigen origenServicio;

//     @GetMapping(path = "/{id}")
//     public ResponseEntity<Origen> traerOirgen(@NonNull @PathVariable Integer id) {
//         Optional<Origen> optOrigen = origenServicio.buscarOrigenPorId(id);
//         if (optOrigen.isPresent()) {
//             Origen origen = optOrigen.get();
//             return ResponseEntity.ok(origen);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//     public ResponseEntity<Origen> agregarCaduce(@NonNull @Valid @RequestBody Origen origenes) {
//         Origen origen = origenServicio.guardarOrigen(origenes);
//         URI location = ServletUriComponentsBuilder
//                 .fromCurrentRequest()
//                 .buildAndExpand(origen.getIdOrigen())
//                 .toUri();
//         return ResponseEntity.created(location).body(origen);
//     }

//     @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//     public ResponseEntity<Origen> agregarOrigen(@NonNull @Valid @RequestBody Origen origenes) {
//         Origen origen = origenServicio.editarOrigen(origenes);
//         Integer id = origen.getIdOrigen();
//         if (id == null) {
//             return ResponseEntity.badRequest().build();
//         }
//         return origenServicio.buscarOrigenPorId(id)
//                 .map((iterarActualizar -> ResponseEntity.ok(origenServicio.editarOrigen(origen))))
//                 .orElseGet(() -> ResponseEntity.notFound().build());
//     }

//     @DeleteMapping(path = "/{id}")
//     public ResponseEntity<Origen> eliminarOrigen(@NonNull @PathVariable Integer id) {
//         return origenServicio.buscarOrigenPorId(id).map(iterarEliminacion -> {
//             origenServicio.eliminarOrigenPorId(id);
//             return ResponseEntity.ok(iterarEliminacion);
//         }).orElseGet(() -> ResponseEntity.notFound().build());
//     }
// }
