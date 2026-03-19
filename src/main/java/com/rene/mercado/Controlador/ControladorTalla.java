package com.rene.mercado.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.rene.mercado.Modelo.Talla;
import com.rene.mercado.Servicio.ServicioTalla;

@Controller
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/talla")
public class ControladorTalla {

    @Autowired
    private ServicioTalla tallaService;

    @GetMapping
    public ModelAndView listar() {

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();
        
        List<Talla> listaDatosTallas = tallaService.obtenerTallas();

        modelAndView.setViewName("talla/lista");
        modelAndView.addObject("listaTallas", listaDatosTallas);

        return modelAndView;
    }

    @GetMapping("/nuevo")
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        modelAndView.setViewName("talla/formulario");
        modelAndView.addObject("talla", new Talla());

        return modelAndView;
    }

    @PostMapping("/guardar")
    public ModelAndView guardar(@NonNull @ModelAttribute Talla talla) {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        tallaService.guardarTallas(talla);

        modelAndView.setViewName("redirect:/talla");

        return modelAndView;
    }

    @PostMapping("/editar")
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        modelAndView.setViewName("talla/formulario");
        modelAndView.addObject("talla", tallaService.buscarTallaPorId(id));

        return modelAndView;
    }

    @PostMapping("/eliminar")
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        tallaService.eliminarTallasPorId(id);

        modelAndView.setViewName("redirect:/talla");

        return modelAndView;
    }
}