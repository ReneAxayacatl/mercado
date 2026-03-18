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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// import com.rene.mercado.Modelo.Categoria;
import com.rene.mercado.Modelo.Productos;
import com.rene.mercado.Servicio.ServicioCategoria;
import com.rene.mercado.Servicio.ServicioProductos;

import ch.qos.logback.core.model.Model;

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
    private ServicioProductos productoServicio;
    @Autowired
    private ServicioCategoria categoriaService;
    // @Autowired
    // private ImplementacionServicioCaduce caduceService;

    @GetMapping
    public ModelAndView listar() {

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        modelAndView.setViewName("productos/lista");

        modelAndView.addObject("productos", productoServicio.obtenerProductos());

        return modelAndView;

    }

    @GetMapping("/nuevo")
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        modelAndView.setViewName("productos/formulario");

        modelAndView.addObject("productos", new Productos());
        modelAndView.addObject("categorias", categoriaService.obtenerCategorias());

        return modelAndView;

    }

    @PostMapping("/guardar")
    public ModelAndView guardar(@NonNull @ModelAttribute Productos productos) {

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        productoServicio.guardarProductos(productos);

        modelAndView.setViewName("redirect:/productos");

        return modelAndView;

    }

    @PostMapping("/editar")
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        modelAndView.setViewName("productos/formulario");

        modelAndView.addObject("productos", productoServicio.buscarProductosPorId(id));
        modelAndView.addObject("categorias", categoriaService.obtenerCategorias());

        return modelAndView;
    }

    @PostMapping("/eliminar")
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        productoServicio.eliminarProductosPorId(id);

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/productos");

        return modelAndView;

    }
}