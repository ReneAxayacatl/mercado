// package com.rene.mercado.RestControlador;

// import java.net.URI;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.lang.NonNull;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import com.rene.mercado.Modelo.Caduce;
// import com.rene.mercado.Servicio.ServicioCaduce;

// import jakarta.validation.Valid;

// @RestController
// @CrossOrigin(origins = "*", methods = {
//         RequestMethod.GET,
//         RequestMethod.POST,
//         RequestMethod.DELETE,
//         RequestMethod.PUT,
// })
// @RequestMapping("rene/api/Caduce")
// public class RestControladorCaduce {

//     // public static final String CADUCE_ENDPOINT = "/rene/caduce";

//     @Autowired
//     private ServicioCaduce caduceService;

//     @GetMapping(path = "/{id}")
//     public Caduce traerCaduce(@NonNull @PathVariable("id") Integer id) {
//         Caduce caduce = caduceService.buscarCaducePorId(id);
//         return caduce;
//         // if (optCaduce.isPresent()) {
//         // Caduce caduce = optCaduce.get();
//         // return ResponseEntity.ok(caduce);
//         // } else {
//         // return ResponseEntity.notFound().build();
//         // }
//     }

//     @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//     public ResponseEntity<Caduce> agregarCaduce(@NonNull @Valid @RequestBody Caduce caduca) {
//         Caduce caduce = caduceService.guardarCaduce(caduca);
//         URI location = ServletUriComponentsBuilder
//                 .fromCurrentRequest()
//                 .buildAndExpand(caduce.getIdCaduce())
//                 .toUri();
//         return ResponseEntity.created(location).body(caduce);
//         // URI location = URI.create(CADUCE_ENDPOINT + "/" + caduce.getIdCaduce());
//         // return ResponseEntity.created(location).body(caduce);
//     }

//     @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//     public ResponseEntity<Caduce> editarCaduce(@NonNull @Valid @RequestBody Caduce caduca) {
//         Caduce caduce = caduceService.editarCaduce(caduca);
//         Integer id = caduce.getIdCaduce();
//         if (id == null) {
//             return ResponseEntity.badRequest().build();
//         }
//         return caduceService.buscarCaducePorId(id)
//                 .map(iterarActualizar -> ResponseEntity.ok(caduceService.editarCaduce(caduce)))
//                 .orElseGet(() -> ResponseEntity.notFound().build());
//     }

//     // @DeleteMapping(path = "/{id}")
//     // public ResponseEntity<Caduce> eliminarCaduce(@NonNull @PathVariable("id")
//     // Integer id) {
//     // return caduceService.buscarCaducePorId(id)
//     // .map(iterarEliminacion -> {
//     // caduceService.eliminarCaducePorId(id);
//     // return ResponseEntity.ok(iterarEliminacion);
//     // })
//     // .orElseGet(() -> ResponseEntity.notFound().build());
//     // }
//     @DeleteMapping(path = "/{id}")
//     public void eliminarCaduce(@PathVariable("id") Integer id) {
//         Caduce caduce = caduceService.buscarCaducePorId(id);

//         if (caduce == null) {
//             throw new RuntimeException("Caduce no encontrado con id " + id);
//         }

//         caduceService.eliminarCaducePorId(id);
//     }

// }
