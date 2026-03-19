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

import com.rene.mercado.Modelo.Productos;
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
@RequestMapping("/productos")                                                        // Ruta global base que manejara toda la clase ControladorProductos
public class ControladorProductos {

    @Autowired
    private ServicioProductos productoServicio;                                      // Inyeccion de servicio productos
    @Autowired
    private ServicioCategoria categoriaService;                                      // Inyeccion de servicio categoria

    @GetMapping // Funcion que muestra la lista de los registros de productos registrados (TOP)
    public ModelAndView listar() {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista prodcutos
        List<Productos> listaDatosProductos = null;                                 // Variable que almacena la lista de informacion registrada de productos.

        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndViews
        listaDatosProductos = productoServicio.obtenerProductos();                  // Metodo para Obtener los datos registrado de productos.

        modelAndView.setViewName("productos/lista");                                // Asignamos la vista de nuestra lista para visualizar los registros.

        modelAndView.addObject("productos", listaDatosProductos);                   // Agregamos la lista de datos de Productos que obtuvimos del servicio productos.

        return modelAndView;
    } // Funcion que muestra la lista de los registros de productos registrados (BOTTOM)

    @GetMapping("/nuevo") // Funcion que crea un nuevo registro de producto (TOP)
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista productos

        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("productos/formulario");                           // Asignamos la vista de nuestro formulario para crear nuevos registros.

        modelAndView.addObject("productos", new Productos());                       // Creamos un nuevo registro al formulario de prodcutos
        modelAndView.addObject("categorias", categoriaService.obtenerCategorias()); // Obtenemos y agregamos la listad de Datos de categoria para el formulario de producto.

        return modelAndView;
    } // Funcion que crea un nuevo registro de producto (BOTTOM)

    @PostMapping("/guardar") // Funcion que guarda un nuevo registro de producto (TOP)
    public ModelAndView guardar(@NonNull @ModelAttribute Productos productos) {

        ModelAndView modelAndView = null;                                            // Variable que almacena las operaciones de la vista productos

        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndView
        productoServicio.guardarProductos(productos);                               // Guardamos el objeto productos que recibimos del formulario de los registros.

        modelAndView.setViewName("redirect:/productos");                            // / Definimos la vista para redireccionar a la lista de los registros de productos después de guardar un nuevo registro

        return modelAndView;
    } // Funcion que guarda un nuevo registro de producto (BOTTOM)

    @PostMapping("/editar") // Funcion que edita un registro de productos (TOP)
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista productos

        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("productos/formulario");                           // Asignamos la vista de nuestro formulario para editar el registro seleccionado.

        modelAndView.addObject("productos", productoServicio.buscarProductosPorId(id));// Obtenemos y asignamos el registro de productos por su id para el formulario de productos.
        modelAndView.addObject("categorias", categoriaService.obtenerCategorias());    // Obtenemos y asiganmos la listad de Datos de categoria para el formulario de productos.

        return modelAndView;
    } // Funcion que edita un registro de productos (BOTTOM)

    @PostMapping("/eliminar") // Funcion que elimina un registro de productos (TOP)
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                           // Variable que almacena las operaciones de la vista productos
        
        modelAndView = new ModelAndView();                                          // Inicialización de la variable de tipo ModelAndView
        productoServicio.eliminarProductosPorId(id);                                // Eliminamos el registro de productos por su id.

        modelAndView.setViewName("redirect:/productos");                            // Definimos la vista para redireccionar a la lista de los registros de productos después de eliminar un registro

        return modelAndView;
    } // Funcion que elimina un registro de productos (BOTTOM)
}