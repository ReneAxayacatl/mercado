package com.rene.mercado.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rene.mercado.Modelo.Comida;
import com.rene.mercado.Servicio.ServicioComida;
import com.rene.mercado.Servicio.ServicioProductos;

@Controller
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/comida")
public class ControladorComida {

    @Autowired
    private ServicioProductos productoServicio;
    @Autowired
    private ServicioComida comidaService;

    @GetMapping
    public ModelAndView listar() {

        ModelAndView modelAndView = null;
        List<Comida> listaDatosComidas = null;

        modelAndView = new ModelAndView();
        listaDatosComidas = comidaService.obtenerComidas();

        modelAndView.setViewName("comida/lista");
        modelAndView.addObject("listaComidas", listaDatosComidas);

        return modelAndView;
    }

    @GetMapping("/nuevo")
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        modelAndView.setViewName("comida/formulario");
        modelAndView.addObject("comida", new Comida());

        return modelAndView;
    }

    @PostMapping("/guardar")
    public ModelAndView guardar(@NonNull @ModelAttribute Comida comida) {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        comidaService.guardarComidas(comida);

        modelAndView.setViewName("redirect:/comida");

        return modelAndView;
    }

    @PostMapping("/editar")
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        modelAndView.setViewName("comida/formulario");

        modelAndView.addObject("comida", comidaService.buscarComidasPorId(id));
        modelAndView.addObject("productos", productoServicio.obtenerProductos());

        return modelAndView;
    }

    @PostMapping("/eliminar")
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        comidaService.eliminarComidasPorId(id);

        modelAndView.setViewName("redirect:/comida");

        return modelAndView;
    }
}