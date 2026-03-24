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

import com.rene.mercado.Entidad.EntidadCaduce;
import com.rene.mercado.Servicio.ServicioCaduce;

@Controller                                                           
@CrossOrigin(origins = "*", methods = {                               
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/caduce")                                                      // Permite gestionar operaciones relacionadas con Caduce.
public class ControladorCaduce {

    @Autowired
    private ServicioCaduce caduceService;                                       // Variable que almacena las operaciones definidas para el contexto de caducidad.

    @GetMapping 
    public ModelAndView listar() {
    // Funcion que muestra la lista de los registros de caducidad registrados (TOP)
        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista.
        List<EntidadCaduce> listaDatosCaduce = null;                                // Variable que almacena la lista de informacion registrada de caduce.

        modelAndView = new ModelAndView();                                          // Inicialización de la variable 
        listaDatosCaduce = caduceService.obtenerCaduce();                           // Asiganmos los datos obetenidos de Caduce.

        modelAndView.setViewName("caduce/listaCaduce");                   // Asignamos la vista de nuestra lista.
        modelAndView.addObject("listDatosCaduce", listaDatosCaduce); // Enviamos la lista con los datos obtenidos a la vista. 

        return modelAndView;
    } // Funcion que muestra la lista de los registros de caducidad registrados (BOTTOM)

    @GetMapping("/nuevo") // Funcion que crea un nuevo registro de caducidad (TOP)
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista.

        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("caduce/formularioCaduce");              // Definimos la vista para mostrar el formulario de registro de caduce
        modelAndView.addObject("caduce", new EntidadCaduce());       // Agregamos un nuevo objeto de tipo Caduce para el formulario de registro

        return modelAndView;
    }// Funcion que crea un nuevo registro de caducidad (BOTTOM)

    @PostMapping("/guardar") // Funcion que guarda los registros de caducidad (TOP)
    public ModelAndView guardar(@NonNull @ModelAttribute EntidadCaduce caduce) {

        ModelAndView modelAndView = null;                            // Variable que almacena las operaciones de la vista caduce

        modelAndView = new ModelAndView();                          // Inicialización de la variable de tipo ModelAndView
        caduceService.guardarCaduce(caduce);                        // Guardamos el objeto caduce que recibimos del formulario de los registros a través del servicio caduceService

        modelAndView.setViewName("redirect:/caduce");               // Definimos la vista para redireccionar a la lista de los registros de caducidad después de guardar un nuevo registro

        return modelAndView;
    } // Funcion que guarda los registros de caducidad (BOTTOM)

    @PostMapping("/eliminar") // Funcion que elimina los registros de caducidad (TOP)
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                           // Variable que almacena las operaciones de la vista caduce

        modelAndView = new ModelAndView();                          // Inicialización de la variable de tipo ModelAndView
        caduceService.eliminarCaducePorId(id);                      // Eliminamos el registro de caducidad por su id a través del servicio caduceService

        modelAndView.setViewName("redirect:/caduce");               // Definimos la vista para redireccionar a la lista de los registros de caducidad después de eliminar un registro
        return modelAndView;
    } // Funcion que elimina los registros de caducidad (BOTTOM)
}