package com.rene.mercado.Controlador;

// import java.net.URI;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rene.mercado.Modelo.Categoria;
import com.rene.mercado.Servicio.ServicioCaduce;
import com.rene.mercado.Servicio.ServicioCategoria;

// import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@Controller                                                             //Componente que regresa nuestras peticiones con vista Thymeleaf y ModelAndView
@CrossOrigin(origins = "*", methods = {                                 //Anotacion para manejar peticiones completas Crud
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/categoria")                                           //Ruta global base que manejara toda la clase ControladorCategoria
public class ControladorCategoria {

    @Autowired
    private ServicioCategoria categoriaService;           //Inyeccion de la dependencia servicio categoria 'categoriaService'

    @Autowired
    private ServicioCaduce caduceService;                 //Inyeccion de la dependencia servicio caduce 'caduceService'

    @GetMapping
    public ModelAndView listar() {                                      //Metodo Get para traer la vista de 'lista.html'

        ModelAndView mav = new ModelAndView("categorias/lista");//Objeto que trae la vista 'lista.html' con ModelAndView

        mav.addObject("categorias",                         //Obtenemos lista de Categoria para nuestro atributo categoria.
                categoriaService.obtenerCategorias());

        return mav;                                                     //Retornamos nuestra obejto de nuestra vista 'categoria/lista'

    }

    @GetMapping("/nuevo")                                               //Metodo Get para traer la vista con la ruta '/nuevo'
    public ModelAndView nuevo() {

        ModelAndView mav = new ModelAndView("categorias/formulario");//Objeto que trae la vista con la ruta 'categoria/formulario' con ModelAndView

        mav.addObject("categorias", new Categoria());     //Cremos un objeto Categoria a nuestro atributo categoria
        mav.addObject("caduces", caduceService.obtenerCaduce());//Cremos un objeto Caduce a nuestro atributo caduce

        return mav;                                                     //Retornamos nuestro objeto con nuestra vista 'categoria/formulario'

    }

    @PostMapping("/guardar")                                            //Mandamos una peticion Post con la ruta '/guardar'
    public String guardar(@NonNull @ModelAttribute Categoria c) {       //Metodo que maneja peticion post de tipo Categoria

        categoriaService.guardarCategorias(c);                          //Metodo para guardar categoria

        return "redirect:/categoria";                                   //Retornamos la vista a '/categoria'

    }

    @GetMapping("/editar/{id}")                                         //Peticion Get para traer por la ruta el id a eliminar '/eliminar/{id}'
    public ModelAndView editar(@NonNull @PathVariable Integer id) {

        ModelAndView mav = new ModelAndView("categorias/formulario");//Objeto para traer formulario de nuevo

        Categoria categoria = categoriaService.buscarCategoriasPorId(id).orElseThrow();

        mav.addObject("categorias", categoria);
        mav.addObject("caduces", caduceService.obtenerCaduce());

        return mav;
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@NonNull @PathVariable Integer id) {

        categoriaService.eliminarCategoriasPorId(id);

        return "redirect:/categoria";

    }

    // @GetMapping(path = "/{id}")
    // public ResponseEntity<Categoria> traerCategoria(@NonNull @PathVariable("id")
    // Integer id) {
    // Optional<Categoria> optCategoria =
    // categoriaService.buscarCategoriasPorId(id);
    // if (optCategoria.isPresent()) {
    // Categoria categoria = optCategoria.get();
    // return ResponseEntity.ok(categoria);
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // }

    // @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Categoria> agregarCategoria(@NonNull @Valid
    // @RequestBody Categoria categorias) {
    // Categoria categoria = categoriaService.guardarCategorias(categorias);
    // return ResponseEntity
    // .created(URI.create("/Categoria" + categoria.getIdCategoria()))
    // .body(categoria);
    // }

    // @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Categoria> editarCaduce(@NonNull @Valid @RequestBody
    // Categoria categorias) {
    // Categoria categoria = categoriaService.editarCategorias(categorias);
    // Integer id = categoria.getIdCategoria();
    // if (id == null) {
    // return ResponseEntity.badRequest().build();
    // }
    // return categoriaService.buscarCategoriasPorId(id)
    // .map(iterarActualizar ->
    // ResponseEntity.ok(categoriaService.editarCategorias(categoria)))
    // .orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // @DeleteMapping(path = "/{id}")
    // public ResponseEntity<Categoria> eliminarCaduce(@NonNull @PathVariable("id")
    // Integer id) {
    // return categoriaService.buscarCategoriasPorId(id)
    // .map(iterarEliminacion -> {
    // categoriaService.eliminarCategoriasPorId(id);
    // return ResponseEntity.ok(iterarEliminacion);
    // })
    // .orElseGet(() -> ResponseEntity.notFound().build());
    // }
}
