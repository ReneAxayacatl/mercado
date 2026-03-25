package com.rene.mercado.Controlador;

import java.util.ArrayList;
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

import com.rene.mercado.Entidad.EntidadComida;
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
@RequestMapping("/comida")                                                          // Permite gestionar operaciones relacionadas con Comida.
public class ControladorComida {

    @Autowired
    private ServicioProductos productoServicio;                                     // Variable que almacena las operaciones definidas para el contexto de producto
    @Autowired
    private ServicioComida comidaService;                                           // Variable que almacena las operaciones definidas para el contexto de comida.
    @Autowired
    private ServicioOrigen origenServicio;                                          // Variable que almacena las operaciones definidas para el contexto de origen

    @GetMapping 
    public ModelAndView listar() {
        // Funcion que muestra la lista de los datos registrados de comida (TOP)
        ModelAndView modelAndView = null;                                               // Variable que almacena las operaciones de la vista comida.
        List<EntidadComida> listaDatosComidas = null;                                   // Variable que almacena la lista de informacion registrada de comida.

        modelAndView = new ModelAndView();                                              // Inicialización de la variable que almacena el objeto ModelAndView de la lista comida.
        listaDatosComidas = comidaService.obtenerComidas();                             // Almacenamos los datos de la lista que obtuvimos de comida.

        modelAndView.setViewName("comida/listaComida");                       // Se define la direccion de la vista comida.
        modelAndView.addObject("listaComidas", listaDatosComidas);       // Agregamos la lista con los datos obtenidos a la vista. 

        return modelAndView;
    } // Funcion que muestra la lista de los datos registrados de comida (BOTTOM)

    @GetMapping("/nuevo") 
    public ModelAndView nuevo() {
        // Funcion que crea un nuevo registro de Comida (TOP)
        ModelAndView modelAndView = null;                                               // Variable que almacena las operaciones de la vista comida
        modelAndView = new ModelAndView();                                              // Inicialización de la variable que almacena el objeto ModelAndView de la lista comida.
        
        modelAndView.setViewName("comida/formularioComida");                  // Definimos la direccion del formulario con los datos del contexto a nuestra vista comida.
        modelAndView.addObject("comida", new EntidadComida());           // Agregamos un nuevo registro para nuestro contexto de comida.
        // modelAndView.addObject("productos", productoServicio.obtenerProductos()); // Agregamos la lista de Datos de nuestros contexto productos para comida.
        modelAndView.addObject("productos", productoServicio.obtenerProductosFiltrados("Comida")); // Agregamos la lista de Datos de nuestros contexto productos para comida.
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());       // Agregamos la lista de Datos de nuestros contexto origen para nuestro contexto de comida.

        return modelAndView;
    } // Funcion que crea un nuevo registro de Comida (BOTTOM)

    @PostMapping("/guardar")
    public ModelAndView guardar(@ModelAttribute EntidadComida comida,
                            @RequestParam(required = false) List<Integer> idsOrigen) {
        // Funcion para guardar un nuevo registro de comida (TOP)
        ModelAndView modelAndView = null;                                               // Variable que almacena las operaciones de la vista comida.
        
        modelAndView = new ModelAndView();                                              // Inicialización de la variable que almacena el objeto ModelAndView de comida
        comidaService.guardarComida(comida, idsOrigen);                                 // Guarda los datos de comida en la base de datos.

        modelAndView.setViewName("redirect:/comida");                         // Definimos la redireccion a la lista de los registros de comida.
        return modelAndView;
    } // Funcion para guardar un nuevo registro de comida (BOTTOM)

    @PostMapping("/editar")
    public ModelAndView editar(@NonNull @RequestParam Integer id) {
        // Funcion que edita un registro de comida (TOP)
        ModelAndView modelAndView = null;                                                          // Variable que almacena las operaciones de la vista comida

        modelAndView = new ModelAndView();                                                         // Inicialización de la variable que almacena el objeto ModelAndView de comida
        modelAndView.setViewName("comida/formularioComida");                             // Definimos la direccion del formulario con los datos del contexto a nuestra vista comida.

        modelAndView.addObject("comida", comidaService.buscarComidasPorId(id));     // Agregamos los datos que se obtuvieron por el Id correspondiente de comida
        modelAndView.addObject("productos", productoServicio.obtenerProductosFiltrados("Comida")); // Agregamos la lista de Datos de nuestros contexto productos para comida.
        // modelAndView.addObject("productos", productoServicio.obtenerProductos());   // Agregamos la lista de Datos de nuestros contexto producto para comida.
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());         // Agregamos la lista de Datos de nuestros contexto origen para la comida.

        return modelAndView;
    } // Funcion que edita un registro de comida (BOTTOM)

    @PostMapping("/eliminar") 
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {
        // Funcion que elimina un registro de comida (TOP)
        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista comida

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable que almacena el objeto ModelAndView de comida
        comidaService.eliminarComidasPorId(id);                                                 // Eliminamos el registro de comida por el ID correspondiente en la base de datos.

        modelAndView.setViewName("redirect:/comida");                                 // Definimos para redireccionar a la lista de los registros de comida.

        return modelAndView;
    } // Funcion que elimina un registro de comida (BOTTOM)
}