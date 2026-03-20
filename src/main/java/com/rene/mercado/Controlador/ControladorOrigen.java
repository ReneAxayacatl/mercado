package com.rene.mercado.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.rene.mercado.Entidad.EntidadOrigen;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioOrigen;

@Controller
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/origen")                                                          // Ruta global base que manejara toda la clase ControladorOrigen
public class ControladorOrigen {

    @Autowired
    private ImplementacionServicioOrigen origenServicio;                            // Inyecccion de servicio Origen.

    @GetMapping // Funcion que muestra la lista de los registros de origen registrados (TOP)
    public ModelAndView listar() {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista origen.
        List<EntidadOrigen> listaDatosOrigen = null;                                       // Variable que almacena la lista de informacion registrada de origen.

        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndView
        listaDatosOrigen = origenServicio.obtenerOrigen();                          // Obtener los datos registrado de origen.

        modelAndView.setViewName("origen/listaOrigen");                           // Asignamos la vista de nuestra lista para visualizar los registros.
        modelAndView.addObject("listaOrigen", listaDatosOrigen);      // Agregamos la lista de datos de origen que obtuvimos a la vista.

        return modelAndView;
    } // Funcion que muestra la lista de los registros de origen registrados (BOTTOM)

    @GetMapping("/nuevo") // Funcion que crea un nuevo registro de origen (TOP)
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista origen

        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("origen/formularioOrigen");                    // Asigamos la vista de nuestro formulario para crear nuevos registros.
        modelAndView.addObject("origen", new EntidadOrigen());             // Creamos un nuevo registro al formulario de origen.
        return modelAndView;
    } // Funcion que crea un nuevo registro de origen (BOTTOM)

    @PostMapping("/guardar") // Funcion que guarda un nuevo registro de origen (TOP)
    public ModelAndView guardar(@NonNull @ModelAttribute EntidadOrigen origen) {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista origen

        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndView
        origenServicio.guardarOrigen(origen);                                       // Guardamos el objeto origen que recibimos del formulario de los registros

        modelAndView.setViewName("redirect:/origen");                     // Definimos la vista para redireccionar a la lista de los registros de origen después de guardar un nuevo registro

        return modelAndView;
    } // Funcion que guarda un nuevo registro de origen (BOTTOM)

    @PostMapping("/editar") // Funcion que edita un registro de origen (TOP)
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista origen
        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndView 

        modelAndView.setViewName("origen/formularioOrigen");                    // Asigamos la vista de nuestro formulario para editar registros.   
        modelAndView.addObject("origen", origenServicio.buscarOrigenPorId(id)); // Buscamos el registro de origen por su id y lo agregamos al formulario para editarlo.

        return modelAndView;
    } // Funcion que edita un registro de origen (BOTTOM)

    @PostMapping("/eliminar") // Funcion que elimina un registro de origen (TOP)
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista origen

        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndView
        origenServicio.eliminarOrigenPorId(id);                                     // metodo para Eliminar el registro de origen por su id

        modelAndView.setViewName("redirect:/origen");                     // Definimos la vista para redireccionar a la lista de los registros de origen después de eliminar un registro  

        return modelAndView;
    } // Funcion que elimina un registro de origen (BOTTOM)
}