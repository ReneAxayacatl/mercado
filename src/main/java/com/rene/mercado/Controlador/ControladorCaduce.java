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
import org.springframework.web.bind.annotation.RequestParam;
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
    private ServicioCaduce caduceService;                            // Inyeccion de la dependencia servicio caduce 'caduceService'

    @GetMapping // Funcion que muestra la lista de los registros de caducidad registrados (TOP)
    public ModelAndView listar() {

        ModelAndView modelAndView = null;                            // Variable que almacena la vista y los datos que se van a mostrar en la vista 'caduce'
        List<Caduce> listaDatosCaduce = null;                        // Variable que almacena la lista de informacion registrada de caduce.

        modelAndView = new ModelAndView();                           // Inicialización de la variable de tipo ModelAndView
        listaDatosCaduce = caduceService.obtenerCaduce();            // Obtener los datos registrado de caduce.

        modelAndView.addObject("listDatosCaduce", listaDatosCaduce); // Obtenemos lista de Caduce para nuestro atributo listDatosCaduce.
        modelAndView.setViewName("caduce/lista");                    // Asignamos la vista 'caduce/lista' a nuestro objeto modelAndView

        return modelAndView;
    } // Funcion que muestra la lista de los registros de caducidad registrados (BOTTOM)

    @GetMapping("/nuevo") // Funcion que crea un nuevo registro de caducidad (TOP)
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;                            // Variable que almacena la vista y los datos que se van a mostrar en la vista 'caduce'

        modelAndView = new ModelAndView();                           // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("caduce/formulario");               // Definimos la vista para mostrar el formulario de registro de caduce
        modelAndView.addObject("caduce", new Caduce());              // Agregamos un nuevo objeto de tipo Caduce para el formulario de registro

        return modelAndView;
    }// Funcion que crea un nuevo registro de caducidad (BOTTOM)

    @PostMapping("/guardar") // Funcion que guarda los registros de caducidad (TOP)
    public ModelAndView guardar(@NonNull @ModelAttribute Caduce caduce) {

        ModelAndView modelAndView = null;                            // Variable que almacena la vista y los datos que se van a mostrar en la vista 'caduce'

        modelAndView = new ModelAndView();                          // Inicialización de la variable de tipo ModelAndView
        caduceService.guardarCaduce(caduce);                        // Guardamos el objeto caduce que recibimos del formulario de los registros a través del servicio caduceService

        modelAndView.setViewName("redirect:/caduce");               // Definimos la vista para redireccionar a la lista de los registros de caducidad después de guardar un nuevo registro

        return modelAndView;
    } // Funcion que guarda los registros de caducidad (BOTTOM)

    @PostMapping("/eliminar") // Funcion que guarda los registros de caducidad (TOP)
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                           // Variable que almacena la vista y los datos que se van a mostrar en la vista 'caduce'

        modelAndView = new ModelAndView();                          // Inicialización de la variable de tipo ModelAndView
        caduceService.eliminarCaducePorId(id);                      // Eliminamos el registro de caducidad por su id a través del servicio caduceService

        modelAndView.setViewName("redirect:/caduce");               // Definimos la vista para redireccionar a la lista de los registros de caducidad después de eliminar un registro
        return modelAndView;
    } // Funcion que guarda los registros de caducidad (BOTTOM)
}