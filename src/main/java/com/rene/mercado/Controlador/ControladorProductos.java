package com.rene.mercado.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rene.mercado.Entidad.EntidadProductos;
import com.rene.mercado.Servicio.ServicioCategoria;
import com.rene.mercado.Servicio.ServicioProductos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller                                                                          
@CrossOrigin(origins = "*", methods = {                                              
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/productos")                                                        // Permite gestionar operaciones relacionadas con Productos.
public class ControladorProductos {

    @Autowired
    private ServicioProductos productoServicio;                                      // Variable que almacena las operaciones definidas para el contexto de producto
    @Autowired
    private ServicioCategoria categoriaService;                                      // Variable que almacena las operaciones definidas para el contexto de categoria

    @GetMapping 
    public ModelAndView listar() {
        // Funcion que muestra la lista de los datos registrados de productos (TOP)
        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista producto
        List<EntidadProductos> listaDatosProductos = null;                          // Variable que almacena la lista de informacion registrada de productos

        modelAndView = new ModelAndView();                                          // Inicialización de la variable que almacena el objeto ModelAndView de la lista productos
        listaDatosProductos = productoServicio.obtenerProductos();                  // Almacenamos los datos de la lista que obtuvimos de productos

        modelAndView.setViewName("productos/listaProductos");             // Se define la direccion de la vista productos
        modelAndView.addObject("productos", listaDatosProductos);    // Agregamos la lista con los datos obtenidos a la vista.

        return modelAndView;
    } // Funcion que muestra la lista de los datos registrados de productos (BOTTOM)

    @GetMapping("/nuevo") 
    public ModelAndView nuevo() {
        // Funcion que crea un nuevo registro de producto (TOP)
        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista producto

        modelAndView = new ModelAndView();                                          // Inicialización de la variable que almacena el objeto ModelAndView de la lista producto
        modelAndView.setViewName("productos/formularioProductos");        // Definimos la direccion del formulario con los datos del contexto a nuestra vista producto

        modelAndView.addObject("productos", new EntidadProductos()); // Agregamos un nuevo registro para nuestro contexto de producto
        modelAndView.addObject("categorias", categoriaService.obtenerCategorias()); // Agregamos la lista de Datos de nuestros contexto categoria para productos

        return modelAndView;
    } // Funcion que crea un nuevo registro de producto (BOTTOM)

    @PostMapping("/guardar") 
    public ModelAndView guardar(@NonNull @ModelAttribute EntidadProductos productos) {
        // Funcion que guarda un nuevo registro de producto (TOP)
        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista productos

        modelAndView = new ModelAndView();                                          // Inicialización de la variable que almacena el objeto ModelAndView de producto
        productoServicio.guardarProductos(productos);                               // Guarda los datos de producto en la base de datos.

        modelAndView.setViewName("redirect:/productos");                  // Definimos la redireccion a la lista de los registros de productos

        return modelAndView;
    } // Funcion que guarda un nuevo registro de producto (BOTTOM)

    @PostMapping("/editar") 
    public ModelAndView editar(@NonNull @RequestParam Integer id) {
        // Funcion que edita un registro de productos (TOP)
        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista productos

        modelAndView = new ModelAndView();                                          // Inicialización de la variable que almacena el objeto ModelAndView de producto
        modelAndView.setViewName("productos/formularioProductos");        // Definimos la direccion del formulario con los datos del contexto a nuestra vista productos

        modelAndView.addObject("productos", productoServicio.buscarProductosPorId(id));// Agregamos los datos que se obtuvieron por el Id correspondiente de productos
        modelAndView.addObject("categorias", categoriaService.obtenerCategorias());    // Agregamos la lista de Datos de nuestros contexto categoria para productos

        return modelAndView;
    } // Funcion que edita un registro de productos (BOTTOM)

    @PostMapping("/eliminar") // Funcion que elimina un registro de productos (TOP)
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista productos
        
        modelAndView = new ModelAndView();                                          // Inicialización de la variable que almacena el objeto ModelAndView de producto
        productoServicio.eliminarProductosPorId(id);                                // Eliminamos el registro de productos por el ID correspondiente en la base de datos.

        modelAndView.setViewName("redirect:/productos");                  // Definimos para redireccionar a la lista de los registros de producto

        return modelAndView;
    } // Funcion que elimina un registro de productos (BOTTOM)
}