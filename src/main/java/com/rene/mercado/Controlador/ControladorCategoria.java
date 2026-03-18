package com.rene.mercado.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Modelo.Categoria;
import com.rene.mercado.Servicio.ServicioCaduce;
import com.rene.mercado.Servicio.ServicioCategoria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    private ServicioCategoria categoriaService;
    @Autowired
    private ServicioCaduce caduceService;

    @GetMapping
    public ModelAndView listar() {

        ModelAndView modelAndView = null;
        List<Categoria> listaDatosCategorias = null;

        modelAndView = new ModelAndView();
        listaDatosCategorias = categoriaService.obtenerCategorias();

        modelAndView.setViewName("categorias/lista");
        modelAndView.addObject("categorias", listaDatosCategorias);

        return modelAndView;

    }

    @GetMapping("/nuevo")
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        modelAndView.setViewName("categorias/formulario");

        modelAndView.addObject("categorias", new Categoria());
        modelAndView.addObject("caduces", caduceService.obtenerCaduce());

        return modelAndView;

    }

    @PostMapping("/guardar")
    public ModelAndView guardar(@NonNull @ModelAttribute Categoria categoria) {

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        categoriaService.guardarCategorias(categoria);

        modelAndView.setViewName("redirect:/categoria");

        return modelAndView;

    }

    @PostMapping("/editar")
    public ModelAndView editar(@NonNull @RequestParam Integer id) {
        ;
        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        modelAndView.setViewName("categorias/formulario");

        modelAndView.addObject("categorias", categoriaService.buscarCategoriasPorId(id));
        modelAndView.addObject("caduces", caduceService.obtenerCaduce());

        return modelAndView;
    }

    @PostMapping("/eliminar")
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        categoriaService.eliminarCategoriasPorId(id);

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/categoria");

        return modelAndView;

    }
}
