package com.rene.mercado.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.rene.mercado.Entidad.EntidadTalla;
import com.rene.mercado.Servicio.ServicioTalla;

@Controller
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/talla")                                                                       // Permite gestionar operaciones relacionadas con Talla
public class ControladorTalla {

    @Autowired
    private ServicioTalla tallaService;                                                         // Variable que almacena las operaciones definidas para el contexto de talla

    @GetMapping 
    public ModelAndView listar() {
        // Funcion que muestra la lista de los datos registrados de talla (TOP)
        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista talla
        List<EntidadTalla> listaDatosTallas = null;                                             // Variable que almacena la lista de informacion registrada de talla.

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable que almacena el objeto ModelAndView de la lista talla.
        listaDatosTallas = tallaService.obtenerTallas();                                        // Almacenamos los datos de la lista que obtuvimos de talla.

        modelAndView.setViewName("talla/listaTalla");                                 // Se define la direccion de la vista talla.
        modelAndView.addObject("listaTallas", listaDatosTallas);                 // Agregamos la lista con los datos obtenidos a la vista. 

        return modelAndView;
    } // Funcion que muestra la lista de los datos registrados de talla (BOTTOM)

    @GetMapping("/nuevo") 
    public ModelAndView nuevo() {
        // Funcion que crea un nuevo registro de talla (TOP)
        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista talla
        modelAndView = new ModelAndView();                                                      // Inicialización de la variable que almacena el objeto ModelAndView de la lista talla.

        modelAndView.setViewName("talla/formularioTalla");                            // Definimos la direccion del formulario con los datos del contexto a nuestra vista talla.
        modelAndView.addObject("talla", new EntidadTalla());                     // Agregamos un nuevo registro para nuestro contexto de talla.

        return modelAndView;
    } // Funcion que crea un nuevo registro de talla (BOTTOM)

    @PostMapping("/guardar") 
    public ModelAndView guardar(@NonNull @ModelAttribute EntidadTalla talla) {
        // Funcion que guarda un nuevo registro de talla (TOP)
        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista talla.

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable que almacena el objeto ModelAndView de talla
        tallaService.guardarTallas(talla);                                                      // Guarda los datos de talla en la base de datos.

        modelAndView.setViewName("redirect:/talla");                                  // Definimos la redireccion a la lista de los registros de talla

        return modelAndView;
    } // Funcion que guarda un nuevo registro de talla (BOTTOM)

    @PostMapping("/editar") 
    public ModelAndView editar(@NonNull @RequestParam Integer id) {
        // Funcion que edita un registro de talla (TOP)
        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista talla
        modelAndView = new ModelAndView();                                                      // Inicialización de la variable que almacena el objeto ModelAndView de talla

        modelAndView.setViewName("talla/formularioTalla");                            // Definimos la direccion del formulario con los datos del contexto a nuestra vista talla.
        modelAndView.addObject("talla", tallaService.buscarTallaPorId(id));      // Agregamos los datos que se obtuvieron por el Id correspondiente de talla

        return modelAndView;
    } // Funcion que edita un registro de talla (BOTTOM)

    @PostMapping("/eliminar") 
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {
        // Funcion que elimina un registro de talla (TOP)
        ModelAndView modelAndView = null;                                                                 // Variable que almacena las operaciones de la vista talla

        modelAndView = new ModelAndView();                                                                // Inicialización de la variable que almacena el objeto ModelAndView de talla
        tallaService.eliminarTallasPorId(id);                                                             // Eliminamos el registro de talla por el ID correspondiente en la base de datos.

        modelAndView.setViewName("redirect:/talla");                                            // Definimos para redireccionar a la lista de los registros de talla.

        return modelAndView;
    } // Funcion que elimina un registro de talla (BOTTOM)
}