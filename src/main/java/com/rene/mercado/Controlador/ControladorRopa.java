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

import com.rene.mercado.Entidad.EntidadRopa;
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
@RequestMapping("/ropa")                                                                        // Permite gestionar operaciones relacionadas con Ropa.
public class ControladorRopa {

    @Autowired
    private ServicioRopa ropaServicio;                                                          // Variable que almacena las operaciones definidas para el contexto de ropa
    @Autowired
    private ServicioProductos productoServicio;                                                 // Variable que almacena las operaciones definidas para el contexto de producto
    @Autowired
    private ServicioTalla tallaServicio;                                                        // Variable que almacena las operaciones definidas para el contexto de talla
    @Autowired
    private ServicioOrigen origenServicio;                                                      // Variable que almacena las operaciones definidas para el contexto de origen

    @GetMapping 
    public ModelAndView listar() {
        // Funcion que muestra la lista de los datos registrados de ropa (TOP)
        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista ropa.
        List<EntidadRopa> listaDatosRopa = null;                                                // Variable que almacena la lista de informacion registrada de ropa

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable que almacena el objeto ModelAndView de la lista ropa
        listaDatosRopa = ropaServicio.obtenerRopas();                                           // Almacenamos los datos de la lista que obtuvimos de ropa

        modelAndView.setViewName("ropa/listaRopa");                                   // Se define la direccion de la vista ropa
        modelAndView.addObject("listaRopa", listaDatosRopa);                     // Agregamos la lista con los datos obtenidos a la vista. 

        return modelAndView;
    } // Funcion que muestra la lista de los datos registrados de ropa (BOTTOM)

    @GetMapping("/nuevo") 
    public ModelAndView nuevo() {
        // Funcion que crea un nuevo registro de Ropa (TOP)
        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista ropa
        modelAndView = new ModelAndView();                                                      // Inicialización de la variable que almacena el objeto ModelAndView de la lista ropa

        modelAndView.setViewName("ropa/formularioRopa");                              // Definimos la direccion del formulario con los datos del contexto a nuestra vista ropa
        modelAndView.addObject("ropa", new EntidadRopa());                       // Agregamos un nuevo registro para nuestro contexto de ropa
        modelAndView.addObject("productos", productoServicio.obtenerProductosFiltrados("Ropa")); // Agregamos la lista de Datos de nuestros contexto productos para ropa.
        // modelAndView.addObject("productos", productoServicio.obtenerProductos());// Agregamos la lista de Datos de nuestros contexto productos para comida.
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());      // Agregamos la lista de Datos de nuestros contexto origen para ropa.
        modelAndView.addObject("tallas", tallaServicio.obtenerTallas());         // Agregamos la lista de Datos de nuestros contexto talla para ropa.

        return modelAndView;
    } // Funcion que crea un nuevo registro de Ropa (BOTTOM)

    @PostMapping("/guardar")
    public ModelAndView guardar(@ModelAttribute EntidadRopa ropa,
                                @RequestParam(required = false) List<Integer> idsTalla,
                                @RequestParam(required = false) List<Integer> idsOrigen) {
        // Funcion para guardar un nuevo registro de ropa (TOP)
        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista ropa
        modelAndView = new ModelAndView();                                                      // Inicialización de la variable que almacena el objeto ModelAndView de ropa
        // ropaServicio.guardarRopas(ropa); // JPA se encarga de manejar relaciones y duplicados
        ropaServicio.guardarRopa(ropa, idsTalla, idsOrigen);                                    // Guarda los datos de ropa en la base de datos.
        modelAndView.setViewName("redirect:/ropa");                                   // Definimos la redireccion a la lista de los registros de ropa
        return modelAndView;
    }   // Funcion para guardar un nuevo registro de ropa (BOTTOM)

    @PostMapping("/editar") 
    public ModelAndView editar(@NonNull @RequestParam Integer id) {
        // Funcion que edita un registro de Ropa (TOP)
        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista ropa

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable que almacena el objeto ModelAndView de ropa
        modelAndView.setViewName("ropa/formularioRopa");                              // Definimos la direccion del formulario con los datos del contexto a nuestra vista ropa

        modelAndView.addObject("ropa", ropaServicio.buscarRopasPorId(id));       // Agregamos los datos que se obtuvieron por el Id correspondiente de ropa
        modelAndView.addObject("productos", productoServicio.obtenerProductosFiltrados("Ropa")); // Agregamos aquellos datos que obtuvios de producto que sean unicamente ropa
        // modelAndView.addObject("productos", productoServicio.obtenerProductos()); 
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());      // Agregamos la lista de Datos de nuestros contexto origen para ropa
        modelAndView.addObject("tallas", tallaServicio.obtenerTallas());         // Agregamos la lista de Datos de nuestros contexto talla para ropa

        return modelAndView;
    } // Funcion que edita un registro de Ropa (BOTTOM)

    @PostMapping("/eliminar") 
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {
        // Funcion que elimina un registro de Ropa (TOP)
        ModelAndView modelAndView = null;                                                      // Variable que almacena las operaciones de la vista ropa

        modelAndView = new ModelAndView();                                                     // Inicialización de la variable que almacena el objeto ModelAndView de ropa
        ropaServicio.eliminarRopasPorId(id);                                                   // Eliminamos el registro de ropa por el ID correspondiente en la base de datos.

        modelAndView.setViewName("redirect:/ropa");                                  // Definimos para redireccionar a la lista de los registros de ropa

        return modelAndView;
    } // Funcion que elimina un registro de Ropa (BOTTOM)
}