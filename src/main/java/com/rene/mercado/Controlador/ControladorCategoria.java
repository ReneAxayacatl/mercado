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
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioCaduce;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioCategoria;

// import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/categoria")
public class ControladorCategoria {

    @Autowired
    private ImplementacionServicioCategoria categoriaService;

    @Autowired
    private ImplementacionServicioCaduce caduceService;

    @GetMapping
    public ModelAndView listar() {

        ModelAndView mav = new ModelAndView("categorias/lista");

        mav.addObject("categorias",
                categoriaService.obtenerCategorias());

        return mav;

    }

    @GetMapping("/nuevo")
    public ModelAndView nuevo() {

        ModelAndView mav = new ModelAndView("categorias/formulario");

        mav.addObject("categorias", new Categoria());
        mav.addObject("caduces", caduceService.obtenerCaduce());

        return mav;

    }

    @PostMapping("/guardar")
    public String guardar(@NonNull @ModelAttribute Categoria c) {

        categoriaService.guardarCategorias(c);

        return "redirect:/categoria";

    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@NonNull @PathVariable Integer id) {

        ModelAndView mav = new ModelAndView("categorias/formulario");

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
