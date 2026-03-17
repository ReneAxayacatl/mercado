package com.rene.mercado.Controlador;

// import java.net.URI;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioCaduce;

// import jakarta.validation.Valid;

@Controller                                                             //Componente que regresa nuestras peticiones con vista Thymeleaf y ModelAndView
@CrossOrigin(origins = "*", methods = {                                 //Anotacion para manejar peticiones completas Crud
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/caduce")                                              //Ruta global base que manejara toda la clase ControladorCaduce
public class ControladorCaduce {

    // public static final String CADUCE_ENDPOINT = "/rene/caduce";

    @Autowired
    private ImplementacionServicioCaduce caduceService;                //Inyeccion de la dependencia servicio caduce 'caduceService'

    @GetMapping
    public ModelAndView listar() {                                     //Metodo Get para traer la vista de 'lista.html'

        ModelAndView mav = new ModelAndView("caduce/lista"); //Objeto que trae la vista 'lista.html' con ModelAndView

        mav.addObject("caduce",                         //Obtenemos lista de Caduce para nuestro atributo caduce.
                caduceService.obtenerCaduce());

        return mav;                                                   //Retornamos nuestra obejto de nuestra vista 'caduce/lista'

    }

    @GetMapping("/nuevo")                                             //Metodo Get para traer la vista con la ruta '/nuevo'
    public ModelAndView nuevo() {

        ModelAndView mav = new ModelAndView("caduce/formulario");//Objeto que trae la vista con la ruta 'caduce/formulario' con ModelAndView

        mav.addObject("caduce", new Caduce());          //Cremos un objeto Caduce a nuestro atributo caduce

        return mav;                                                   //Retornamos nuestro objeto con nuestra vista 'caduce/formulario'

    }

    @PostMapping("/guardar")                                          //Mandamos una peticion Post con la ruta '/guardar'
    public String guardar(@NonNull @ModelAttribute Caduce c) {        //Metodo que maneja peticion post de tipo Caduce

        caduceService.guardarCaduce(c);                               //Metodo para guardar caduce

        return "redirect:/caduce";                                    //Retornamos la vista a '/caduce'

    }

    @GetMapping("/eliminar/{id}")                                     //Peticion Get para traer por la ruta el id a eliminar '/eliminar/{id}'
    public String eliminar(@NonNull @PathVariable Integer id) {

        caduceService.eliminarCaducePorId(id);                        //Metodo para eliminar caduce por id

        return "redirect:/caduce";                                    //Retornamos la vista a '/caduce'

    }

    // @GetMapping(path = "/{id}")
    // public ResponseEntity<Caduce> traerCaduce(@NonNull @PathVariable("id")
    // Integer id) {
    // Optional<Caduce> optCaduce = caduceService.buscarCaducePorId(id);
    // if (optCaduce.isPresent()) {
    // Caduce caduce = optCaduce.get();
    // return ResponseEntity.ok(caduce);
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // }

    // @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Caduce> agregarCaduce(@NonNull @Valid @RequestBody
    // Caduce caduca) {
    // Caduce caduce = caduceService.guardarCaduce(caduca);
    // // URI location = URI.create("/Caduce/" + caduce.getIdCaduce());
    // // .created(URI.create("/Caduce" + caduce.getIdCaduce()))
    // // .body(caduce);
    // URI location = ServletUriComponentsBuilder
    // .fromCurrentRequest()
    // .path("{/id}")
    // .buildAndExpand(caduce.getIdCaduce())
    // .toUri();
    // return ResponseEntity.created(location).body(caduce);
    // }

    // @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Caduce> editarCaduce(@NonNull @Valid @RequestBody
    // Caduce caduca) {
    // Caduce caduce = caduceService.editarCaduce(caduca);
    // Integer id = caduce.getIdCaduce();
    // if (id == null) {
    // return ResponseEntity.badRequest().build();
    // }
    // return caduceService.buscarCaducePorId(id)
    // .map(iterarActualizar ->
    // ResponseEntity.ok(caduceService.editarCaduce(caduce)))
    // .orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // @DeleteMapping(path = "/{id}")
    // public ResponseEntity<Caduce> eliminarCaduce(@NonNull @PathVariable("id")
    // Integer id) {
    // return caduceService.buscarCaducePorId(id)
    // .map(iterarEliminacion -> {
    // caduceService.eliminarCaducePorId(id);
    // return ResponseEntity.ok(iterarEliminacion);
    // })
    // .orElseGet(() -> ResponseEntity.notFound().build());
    // }

}
