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

import com.rene.mercado.Modelo.Comida;
import com.rene.mercado.Modelo.Origen;
import com.rene.mercado.Servicio.ServicioComida;
import com.rene.mercado.Servicio.ServicioOrigen;
import com.rene.mercado.Servicio.ServicioProductos;

@Controller
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/comida")                                                          // Ruta global base que manejara toda la clase ControladorComida
public class ControladorComida {

    @Autowired
    private ServicioProductos productoServicio;                                     // Inyeccion de servicio producto.
    @Autowired
    private ServicioComida comidaService;                                           // Inyeccion de servicio comida.
    @Autowired
    private ServicioOrigen origenServicio;                                          // Inyeccion de servicio origen.

    @GetMapping // Funcion que muestra la lista de los registros de Comida registrados (TOP)
    public ModelAndView listar() {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista comida
        List<Comida> listaDatosComidas = null;                                      // Variable que almacena la lista de informacion registrada de comida.

        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndView
        listaDatosComidas = comidaService.obtenerComidas();                         // Obtener los datos registrado de comida.

        modelAndView.setViewName("comida/lista");                           // Asignamos la vista de nuestra lista para visualizar los registros.
        modelAndView.addObject("listaComidas", listaDatosComidas);      // Agregamos la lista de datos de comida que obtuvimos y lo pasamos a la vista.

        return modelAndView;
    } // Funcion que muestra la lista de los registros de Comida registrados (BOTTOM)

    @GetMapping("/nuevo") // Funcion que crea un nuevo registro de Comida (TOP)
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;                                               // Variable que almacena las operaciones de la vista comida

        modelAndView = new ModelAndView();                                              // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("comida/formulario");                          // Asignamos la vista de nuestro formulario para crear nuevos registros.
        modelAndView.addObject("comida", new Comida());                    // Creamos un nuevo registro al formulario de comida.
        modelAndView.addObject("productos", productoServicio.obtenerProductos()); // Obtenemos y agregamos la lista de Datos de productos para el formulario de comida.
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());   // Obtenemos y agregamos la lista de Datos de origen para el formulario de comida.

        return modelAndView;
    } // Funcion que crea un nuevo registro de Comida (BOTTOM)

    // @PostMapping("/guardar") // Funcion que guarda un nuevo registro de comida (TOP)
    // public ModelAndView guardar(@NonNull @ModelAttribute Comida comida) {

    //     ModelAndView modelAndView = null;                                               // Variable que almacena las operaciones de la vista comida

    //     modelAndView = new ModelAndView();                                              // Inicialización de la variable de tipo ModelAndView
    //     comidaService.guardarComidas(comida);                                           // Guardamos el dato del objeto comida que recibimos de los registros del formulario a través del servicio comida.

    //     modelAndView.setViewName("redirect:/comida");                           // Definimos la vista para redireccionar a la lista de los registros de comida después de guardar un nuevo registro

    //     return modelAndView;
    // } // Funcion que guarda un nuevo registro de comida (TOP)
    @PostMapping("/guardar")
public ModelAndView guardar(
    @NonNull @ModelAttribute Comida comida,
    @RequestParam(name = "idsOrigen", required = false) List<Integer> idsOrigen) {

    ModelAndView modelAndView = new ModelAndView();

    comida.setOrigenes(new java.util.ArrayList<>());

    if (idsOrigen != null) {
        for (Integer id : idsOrigen) {

            Origen origen = origenServicio.buscarOrigenPorId(id);

            if (origen != null) {
                comida.getOrigenes().add(origen);
            }
        }
    }

    comidaService.guardarComidas(comida);

    modelAndView.setViewName("redirect:/comida");
    return modelAndView;
}

    @PostMapping("/editar") // Funcion que edita un registro de comida (TOP)
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista comida

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("comida/formulario");                                // Asignamos la vista de nuestro formulario para editar el registro seleccionado.

        modelAndView.addObject("comida", comidaService.buscarComidasPorId(id));     // Obtenemos y asignamos el registro de comida por su id para el formulario de comida.
        modelAndView.addObject("productos", productoServicio.obtenerProductos());   // Obtenemos y agregamos la lista de Datos de productos para el formulario de comida.
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());         // Obtenemos y agregamos la lista de Datos de origen para el formulario de comida.

        return modelAndView;
    } // Funcion que edita un registro de comida (BOTTOM)

    @PostMapping("/eliminar") // Funcion que elimina un registro de comida (TOP)
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista comida

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView
        comidaService.eliminarComidasPorId(id);                                                 // Eliminamos el registro de comida por su id.

        modelAndView.setViewName("redirect:/comida");                                   // Definimos la vista para redireccionar a la lista de los registros de comida después de eliminar un registro

        return modelAndView;
    } // Funcion que elimina un registro de comida (BOTTOM)
}