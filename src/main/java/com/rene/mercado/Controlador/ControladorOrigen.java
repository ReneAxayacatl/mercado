package com.rene.mercado.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.rene.mercado.DTO.DTOOrigen;
import com.rene.mercado.Entidad.EntidadOrigen;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioOrigen;

@Controller
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/origen")                                                          // Permite gestionar operaciones relacionadas con Origen.
public class ControladorOrigen {

    @Autowired
    private ImplementacionServicioOrigen origenServicio;                            // Variable que almacena las operaciones definidas para el contexto de origen.

    @GetMapping 
    public ModelAndView listar() {
        // Funcion que muestra la lista de los datos registrados de origen (TOP)
        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista origen.
        // List<EntidadOrigen> listaDatosOrigen = null;                                // Variable que almacena la lista de informacion registrada de origen.
        List<DTOOrigen> listaDatosOrigen = null;

        modelAndView = new ModelAndView();                                          // Inicialización de la variable que almacena el objeto ModelAndView de la lista origen
        // listaDatosOrigen = origenServicio.obtenerOrigen();                          // Almacenamos los datos de la lista que obtuvimos de origen.
        listaDatosOrigen = origenServicio.obtenerOrigenDTO();

        modelAndView.setViewName("origen/listaOrigen");                   // Se define la direccion de la vista origen.
        modelAndView.addObject("listaOrigen", listaDatosOrigen);     // Agregamos la lista con los datos obtenidos a la vista.

        return modelAndView;
    }// Funcion que muestra la lista de los datos registrados de origen (BOTTOM)

    @GetMapping("/nuevo") 
    public ModelAndView nuevo() {
        // Funcion que crea un nuevo registro de origen (TOP)
        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista origen.

        modelAndView = new ModelAndView();                                          // Inicialización de la variable que almacena el objeto ModelAndView de la lista origen
        modelAndView.setViewName("origen/formularioOrigen");              // Definimos la direccion del formulario con los datos del contexto a nuestra vista origen.
        modelAndView.addObject("origen", new EntidadOrigen());       // Agregamos un nuevo registro para nuestro contexto de origen.
        return modelAndView;
    } // Funcion que crea un nuevo registro de origen (BOTTOM)

    @PostMapping("/guardar") 
    public ModelAndView guardar(@NonNull @ModelAttribute EntidadOrigen origen) {
        // Funcion que guarda un nuevo registro de origen (TOP)
        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista origen.

        modelAndView = new ModelAndView();                                          // Inicialización de la variable que almacena el objeto ModelAndView de la lista origen
        origenServicio.guardarOrigen(origen);                                       // Guarda los datos de origen en la base de datos.

        modelAndView.setViewName("redirect:/origen");                     // Definimos la redireccion a la lista de los registros de origen.

        return modelAndView;
    } // Funcion que guarda un nuevo registro de origen (BOTTOM)

    @PostMapping("/editar") 
    public ModelAndView editar(@NonNull @RequestParam Integer id) {
        // Funcion que edita un registro de origen (TOP)
        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista origen.
        modelAndView = new ModelAndView();                                          // Inicialización de la variable que almacena el objeto ModelAndView de origen

        modelAndView.setViewName("origen/formularioOrigen");                    // Definimos la direccion del formulario con los datos del contexto a nuestra vista origen
        modelAndView.addObject("origen", origenServicio.buscarOrigenPorId(id)); // Agregamos los datos que se obtuvieron por el Id correspondiente de origen

        return modelAndView;
    } // Funcion que edita un registro de origen (BOTTOM)

    @PostMapping("/eliminar") 
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {
        // Funcion que elimina un registro de origen (TOP)
        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista origen

        modelAndView = new ModelAndView();                                          // Inicialización de la variable que almacena el objeto ModelAndView de origen
        origenServicio.eliminarOrigenPorId(id);                                     // Eliminamos el registro de origen por el ID correspondiente en la base de datos.

        modelAndView.setViewName("redirect:/origen");                     // Definimos para redireccionar a la lista de los registros de origen

        return modelAndView;
    } // Funcion que elimina un registro de origen (BOTTOM)
}