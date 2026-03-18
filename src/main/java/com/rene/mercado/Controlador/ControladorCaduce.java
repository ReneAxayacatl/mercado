package com.rene.mercado.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Servicio.ServicioCaduce;
import org.springframework.web.bind.annotation.RequestBody;

@Controller // Componente que regresa nuestras peticiones con vista Thymeleaf y ModelAndView
@CrossOrigin(origins = "*", methods = { // Anotacion para manejar peticiones completas Crud
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/caduce") // Ruta global base que manejara toda la clase ControladorCaduce
public class ControladorCaduce {

    @Autowired
    private ServicioCaduce caduceService; // Inyeccion de la dependencia servicio caduce 'caduceService'

    @GetMapping // Funcion que muestra la lista de los registros de caducidad registrados (TOP)
    public ModelAndView listar() {
        ModelAndView modelAndView = null; // Variable que almacena la vista y los datos que se van a mostrar en la vista
                                          // 'caduce'
        List<Caduce> listaDatosCaduce = null; // Variable que almacena la lista de informacion registrada de caduce.

        modelAndView = new ModelAndView(); // Inicialización de la variable modelAndView
        listaDatosCaduce = caduceService.obtenerCaduce(); // Obtener los datos registrado de caduce.

        modelAndView.addObject("listDatosCaduce", listaDatosCaduce); // Obtenemos lista de Caduce para nuestro atributo
                                                                     // listDatosCaduce.
        modelAndView.setViewName("caduce/lista"); // Asignamos la vista 'caduce/lista' a nuestro objeto modelAndView

        return modelAndView;
    } // Funcion que muestra la lista de los registros de caducidad registrados (BOTTOM)

    @GetMapping("/nuevo") // Funcion que muestra la lista de los registros de caducidad registrados (TOP)
    public ModelAndView nuevo() {
        ModelAndView modelAndView = null;

        modelAndView = new ModelAndView();
        modelAndView.setViewName("caduce/formulario");

        modelAndView.addObject("caduce", new Caduce());

        return modelAndView;

    }

    @PostMapping("/guardar")
    public ModelAndView guardar(@NonNull @ModelAttribute Caduce c) {

        caduceService.guardarCaduce(c);

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/caduce");

        return modelAndView;

    }

    @PostMapping("/eliminar")
    public ModelAndView eliminar(@NonNull @PathVariable Integer id) {

        caduceService.eliminarCaducePorId(id);

        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/caduce");
        return modelAndView;
    }
}