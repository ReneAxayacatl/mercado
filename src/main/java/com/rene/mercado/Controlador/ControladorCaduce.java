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

import com.rene.mercado.DTO.DTOCaduce;
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
        // Funcion que muestra la lista de los datos registrados de caducidad (TOP)
        ModelAndView modelAndView = null;                                                   // Variable que almacena las operaciones de la vista caduce.
        // List<EntidadCaduce> listaDatosCaduce = null;                                        // Variable que almacena la lista de informacion registrada de caduce.
        List<DTOCaduce> listaDatosCaduce = null;

        modelAndView = new ModelAndView();                                                  // Inicialización de la variable que almacena el objeto ModelAndView de la lista caduce.
        listaDatosCaduce = caduceService.obtenerCaducesDTO();                                   // Almacenamos los datos de la lista que obtuvimos de caduce.

        modelAndView.setViewName("caduce/listaCaduce");                            // Se define la direccion de la vista caduce.
        modelAndView.addObject("listDatosCaduce", listaDatosCaduce);          // Agregamos la lista con los datos obtenidos a la vista. 

        return modelAndView;
    }   // Funcion que muestra la lista de los datos registrados de caducidad (BOTTOM)

    @GetMapping("/nuevo") 
    public ModelAndView nuevo() {
        // Funcion que crea un nuevo registro de caducidad (TOP)
        ModelAndView modelAndView = null;                                                   // Variable que almacena las operaciones de la vista caduce.

        modelAndView = new ModelAndView();                                                  // Inicialización de la variable que almacena el objeto ModelAndView para un nuevo registo caduce.
        modelAndView.setViewName("caduce/formularioCaduce");                      // Definimos la direccion del formulario con los datos del contexto a nuestra vista caduce.
        modelAndView.addObject("caduce", new EntidadCaduce());               // Agregamos un nuevo registro para nuestro contexto de Caduce.

        return modelAndView;
    }   // Funcion que crea un nuevo registro de caducidad (BOTTOM)

    @PostMapping("/guardar") 
    public ModelAndView guardar(@NonNull @ModelAttribute EntidadCaduce caduce) {
        // Funcion para guardar los registros de caducidad (TOP)
        ModelAndView modelAndView = null;                                                   // Variable que almacena las operaciones de la vista caduce

        modelAndView = new ModelAndView();                                                  // Inicialización de la variable que almacena el objeto ModelAndView de caduce.
        caduceService.guardarCaduce(caduce);                                                // Guarda los datos de caduce en la base de datos

        modelAndView.setViewName("redirect:/caduce");                             // Definimos la redireccion a la lista de los registros de caducidad.

        return modelAndView;
    } // Funcion para guardar los registros de caducidad (BOTTOM)

    @PostMapping("/eliminar") 
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {
        // Funcion que elimina los registros de caducidad (TOP)
        ModelAndView modelAndView = null;                                                   // Variable que almacena las operaciones de la vista caduce

        modelAndView = new ModelAndView();                                                  // Inicialización de la variable que almacena el objeto ModelAndView de caduce.
        caduceService.eliminarCaducePorId(id);                                              // Eliminamos el registro de caducidad por el ID correspondiente en la base de datos.

        modelAndView.setViewName("redirect:/caduce");                             // Definimos para redireccionar a la lista de los registros de caducidad.
        return modelAndView;
    } // Funcion que elimina los registros de caducidad (BOTTOM)
}