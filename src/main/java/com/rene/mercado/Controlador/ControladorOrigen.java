package com.rene.mercado.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.rene.mercado.Modelo.Origen;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioOrigen;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioProductos;

@Controller
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/origen")
public class ControladorOrigen {

    @Autowired
    private ImplementacionServicioOrigen origenServicio;

    @GetMapping
    public ModelAndView listar() {

        ModelAndView modelAndView = null;
        List<Origen> listaDatosOrigen = null;

        modelAndView = new ModelAndView();
        listaDatosOrigen = origenServicio.obtenerOrigen();

        modelAndView.setViewName("origen/lista");
        modelAndView.addObject("listaOrigen", listaDatosOrigen);

        return modelAndView;
    }

    @GetMapping("/nuevo")
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        modelAndView.setViewName("origen/formulario");
        modelAndView.addObject("origen", new Origen());
        return modelAndView;
    }

    @PostMapping("/guardar")
    public ModelAndView guardar(@NonNull @ModelAttribute Origen origen) {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        origenServicio.guardarOrigen(origen);

        modelAndView.setViewName("redirect:/origen");

        return modelAndView;
    }

    @PostMapping("/editar")
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        modelAndView.setViewName("origen/formulario");
        modelAndView.addObject("origen", origenServicio.buscarOrigenPorId(id));

        return modelAndView;
    }

    @PostMapping("/eliminar")
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        origenServicio.eliminarOrigenPorId(id);

        modelAndView.setViewName("redirect:/origen");

        return modelAndView;
    }
}