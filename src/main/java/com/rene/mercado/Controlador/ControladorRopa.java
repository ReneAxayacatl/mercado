package com.rene.mercado.Controlador;

import java.util.ArrayList;
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

import com.rene.mercado.Modelo.Ropa;
import com.rene.mercado.Modelo.RopaTalla;
import com.rene.mercado.Modelo.RopaTallaPK;
import com.rene.mercado.Modelo.Talla;
import com.rene.mercado.Servicio.ServicioOrigen;
import com.rene.mercado.Servicio.ServicioProductos;
import com.rene.mercado.Servicio.ServicioRopa;
import com.rene.mercado.Servicio.ServicioTalla;

@Controller
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/ropa")
public class ControladorRopa {

    @Autowired
    private ServicioRopa ropaServicio;
    @Autowired
    private ServicioProductos productoServicio;
    @Autowired
    private ServicioTalla tallaServicio;
    @Autowired
    private ServicioOrigen origenServicio;

    @GetMapping
    public ModelAndView listar() {

        ModelAndView modelAndView = null;
        List<Ropa> listaDatosRopa = null;

        modelAndView = new ModelAndView();
        listaDatosRopa = ropaServicio.obtenerRopas();

        modelAndView.setViewName("ropa/lista");
        modelAndView.addObject("listaRopa", listaDatosRopa);

        return modelAndView;
    }

    @GetMapping("/nuevo")
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        modelAndView.setViewName("ropa/formulario");
        modelAndView.addObject("ropa", new Ropa());
        modelAndView.addObject("productos", productoServicio.obtenerProductos());
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());
        modelAndView.addObject("tallas", tallaServicio.obtenerTallas());

        return modelAndView;
    }

    // @PostMapping("/guardar")
    // public ModelAndView guardar(@NonNull @ModelAttribute Ropa ropa) {

    //     ModelAndView modelAndView = null;

    //     modelAndView = new ModelAndView();
    //     ropaServicio.guardarRopas(ropa);

    //     modelAndView.setViewName("redirect:/ropa");

    //     return modelAndView;
    // }
    @PostMapping("/guardar")
    public ModelAndView guardar(@NonNull @ModelAttribute Ropa ropa, 
        @RequestParam(name = "idsTalla", required = false) List<Integer> idsTalla) {

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        ropa.setTallasAsignadas(new ArrayList<>());

        // if (idsTalla != null) {
        if (idsTalla == null || idsTalla.isEmpty()) {
            // No se han seleccionado tallas
        } else {
            for (Integer idTalla : idsTalla) {

                RopaTalla ropaTalla = null;
                ropaTalla = new RopaTalla();

            // Traer Talla real desde BD
            Talla talla = tallaServicio.buscarTallaPorId(idTalla);

            if (talla != null) {

                // Llave Primaria 'PK' para la tabla intermedia 'RopaTalla'
                RopaTallaPK llavePrimaria = new RopaTallaPK();
                llavePrimaria.setIdTalla(idTalla);
                ropaTalla.setId(llavePrimaria);

                ropaTalla.setRopa(ropa);
                ropaTalla.setTalla(talla);

                ropa.getTallasAsignadas().add(ropaTalla);
                }
            }
        }
        ropaServicio.guardarRopas(ropa);
        modelAndView.setViewName("redirect:/ropa");

        return modelAndView;
    }

    @PostMapping("/editar")
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        modelAndView.setViewName("ropa/formulario");

        modelAndView.addObject("ropa", ropaServicio.buscarRopasPorId(id));
        modelAndView.addObject("productos", productoServicio.obtenerProductos());
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());
        modelAndView.addObject("tallas", tallaServicio.obtenerTallas());

        return modelAndView;
    }

    @PostMapping("/eliminar")
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        ropaServicio.eliminarRopasPorId(id);

        modelAndView.setViewName("redirect:/ropa");

        return modelAndView;
    }
}