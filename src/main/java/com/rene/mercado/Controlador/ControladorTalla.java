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
@RequestMapping("/talla")                                                                       // Ruta global base que manejara toda la clase ControladorTalla
public class ControladorTalla {

    @Autowired
    private ServicioTalla tallaService;                                                         // Inyeccion de servicio talla.

    @GetMapping // Funcion que muestra la lista de los registros de talla registrados (TOP)
    public ModelAndView listar() {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista talla
        List<Talla> listaDatosTallas = null;                                                    // Variable que almacena la lista de informacion registrada de talla.

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView
        listaDatosTallas = tallaService.obtenerTallas();                                        // Obtener los datos registrado de tallas.

        modelAndView.setViewName("talla/lista");                                      // Asignamos la vista de nuestra lista para visualizar los registros.
        modelAndView.addObject("listaTallas", listaDatosTallas);                 // Agregamos la lista de datos de talla que obtuvimos a la vista.     

        return modelAndView;
    } // Funcion que muestra la lista de los registros de talla registrados (BOTTOM)

    @GetMapping("/nuevo") // Funcion que crea un nuevo registro de talla (TOP)
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista talla
        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView

        modelAndView.setViewName("talla/formulario");                                 // Asignamos la vista de nuestro formulario para crear nuevos registros.
        modelAndView.addObject("talla", new Talla());                            // Creamos un nuevo registro al formulario de talla.

        return modelAndView;
    } // Funcion que crea un nuevo registro de talla (BOTTOM)

    @PostMapping("/guardar") // Funcion que guarda un nuevo registro de talla (TOP)
    public ModelAndView guardar(@NonNull @ModelAttribute Talla talla) {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista talla

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView
        tallaService.guardarTallas(talla);                                                      // Guardamos el objeto talla que recibimos del formulario de los registros

        modelAndView.setViewName("redirect:/talla");                                  // Definimos la vista para redireccionar a la lista de los registros de talla después de guardar un nuevo registro

        return modelAndView;
    } // Funcion que guarda un nuevo registro de talla (BOTTOM)

    @PostMapping("/editar") // Funcion que edita un registro de talla (TOP)
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista talla
        modelAndView = new ModelAndView();                                                      // Inicializacion de la variable de tipo ModelAndView

        modelAndView.setViewName("talla/formulario");                                           // Asignamos la vista de nuestro formulario para editar el registro seleccionado.
        modelAndView.addObject("talla", tallaService.buscarTallaPorId(id));                // Obtenemos y asignamos el registro de Tallas por su id para el formulario de Tallas

        return modelAndView;
    } // Funcion que edita un registro de talla (BOTTOM)

    @PostMapping("/eliminar") // Funcion que elimina un registro de talla (TOP)
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                                                 // Variable que almacena las operaciones de la vista tallas.

        modelAndView = new ModelAndView();                                                                // Inicialización de la variable de tipo ModelAndView
        tallaService.eliminarTallasPorId(id);                                                             // Eliminamos el registro de productos por su id.

        modelAndView.setViewName("redirect:/talla");                                            // Definimos la vista para redireccionar a la lista de los registros de tallas después de eliminar un registro

        return modelAndView;
    } // Funcion que elimina un registro de talla (BOTTOM)
}