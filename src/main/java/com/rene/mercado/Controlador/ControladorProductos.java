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

// import com.rene.mercado.Modelo.Categoria;
import com.rene.mercado.Modelo.Productos;
// import com.rene.mercado.Servicio.ServicioCategoria;
// import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioCaduce;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioCategoria;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioProductos;

// import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PutMapping;

@Controller
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/productos")
public class ControladorProductos {

    @Autowired
    private ImplementacionServicioProductos productoServicio;
    @Autowired
    private ImplementacionServicioCategoria categoriaService;
    @Autowired
    // private ImplementacionServicioCaduce caduceService;

    @GetMapping
    public ModelAndView listar() {

        ModelAndView mav = new ModelAndView("productos/lista");

        mav.addObject("productos",
                productoServicio.obtenerProductos());

        return mav;

    }

    @GetMapping("/nuevo")
    public ModelAndView nuevo() {

        ModelAndView mav = new ModelAndView("productos/formulario");

        mav.addObject("productos", new Productos());
        mav.addObject("categorias", categoriaService.obtenerCategorias());

        return mav;

    }

    @PostMapping("/guardar")
    public String guardar(@NonNull @ModelAttribute Productos p) {

        productoServicio.guardarProductos(p);

        return "redirect:/productos";

    }
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@NonNull @PathVariable Integer id) {

        ModelAndView mav = new ModelAndView("productos/formulario");

        Productos producto = productoServicio.buscarProductosPorId(id).orElseThrow();

        mav.addObject("productos", producto);
        mav.addObject("categorias", categoriaService.obtenerCategorias());

        return mav;
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@NonNull @PathVariable Integer id) {

        productoServicio.eliminarProductosPorId(id);

        return "redirect:/productos";

    }

    // @GetMapping(path = "/{id}")
    // public ResponseEntity<Productos> traerOrigen(@NonNull @PathVariable Integer
    // id) {
    // Optional<Productos> optProducto = productoServicio.buscarProductosPorId(id);
    // if (optProducto.isPresent()) {
    // Productos producto = optProducto.get();
    // return ResponseEntity.ok(producto);
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // }

    // @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Productos> agregarProductos(@NonNull @Valid
    // @RequestBody Productos productos) {
    // Productos producto = productoServicio.guardarProductos(productos);
    // return ResponseEntity
    // .created(URI.create("/Productos" + producto.getIdProducto()))
    // .body(producto);
    // }

    // @PutMapping(path = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Productos> editarProductos(@NonNull @Valid @RequestBody
    // Productos productos) {
    // Productos producto = productoServicio.editarProductos(productos);
    // Integer id = producto.getIdProducto();
    // if (id == null) {
    // return ResponseEntity.badRequest().build();
    // }
    // return productoServicio.buscarProductosPorId(id)
    // .map(iterarActualizar ->
    // ResponseEntity.ok(productoServicio.editarProductos(producto)))
    // .orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // @DeleteMapping(path = "/{id}")
    // public ResponseEntity<Productos> eliminarProductos(@NonNull @PathVariable
    // Integer id) {
    // return productoServicio.buscarProductosPorId(id)
    // .map(iterarEliminacion -> {
    // productoServicio.eliminarProductosPorId(id);
    // return ResponseEntity.ok(iterarEliminacion);
    // })
    // .orElseGet(() -> ResponseEntity.notFound().build());
    // }
}
