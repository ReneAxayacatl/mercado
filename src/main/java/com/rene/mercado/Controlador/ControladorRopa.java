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

import com.rene.mercado.Modelo.Ropa;
import com.rene.mercado.Modelo.RopaTalla;
import com.rene.mercado.Modelo.RopaTallaPK;
import com.rene.mercado.Modelo.Talla;
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
@RequestMapping("/ropa")
public class ControladorRopa {

    @Autowired
    private ServicioRopa ropaServicio;
    @Autowired
    private ServicioProductos productoServicio;
    @Autowired
    private ServicioTalla tallaServicio;
    @Autowired
    private ServicioOrigen origenServicio;

    @GetMapping // Funcion que muestra la lista de los registros de Ropa registrados (TOP)
    public ModelAndView listar() {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista Ropa.
        List<Ropa> listaDatosRopa = null;                                                       // Variable que almacena la lista de informacion registrada de Ropa

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView
        listaDatosRopa = ropaServicio.obtenerRopas();                                           // Obtener los datos registrado de Ropa.

        modelAndView.setViewName("ropa/lista");                                       // Asignamos la vista de nuestra lista para visualizar los registros.
        modelAndView.addObject("listaRopa", listaDatosRopa);                     // Agregamos la lista de datos de Ropa que obtuvimos a la vista.

        return modelAndView;
    } // Funcion que muestra la lista de los registros de Ropa registrados (BOTTOM)

    @GetMapping("/nuevo") // Funcion que crea un nuevo registro de Ropa (TOP)
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista Ropa.
        modelAndView = new ModelAndView();                                                      // Variable que almacena la lista de informacion registrada de Ropa.

        modelAndView.setViewName("ropa/formulario");                                  // Asignamos la vista de nuestro formulario para crear nuevos registros.
        modelAndView.addObject("ropa", new Ropa());                              // Creamos un nuevo registro al formulario de Ropa.
        modelAndView.addObject("productos", productoServicio.obtenerProductos());// Obtenemos y agregamos la lista de Datos de productos para el formulario de Ropa.
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());      // Obtenemos y agregamos la lista de Datos de origen para el formulario de Ropa.
        modelAndView.addObject("tallas", tallaServicio.obtenerTallas());         // Obtenemos y agregamos la lista de Datos de tallas para el formulario de Ropa.

        return modelAndView;
    } // Funcion que crea un nuevo registro de Ropa (BOTTOM)

    @PostMapping("/guardar") // Funcion que guarda un nuevo registro de Ropa (TOP)
    public ModelAndView guardar(@NonNull @ModelAttribute Ropa ropa, 
        @RequestParam(name = "idsTalla", required = false) List<Integer> idsTalla) {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista Ropa.
        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView   

        ropa.setTallasAsignadas(new ArrayList<>());                                             // Inicializamos la lista de tallas asignadas a la ropa.

        // if (idsTalla != null) {
        if (idsTalla == null || idsTalla.isEmpty()) {                                           // Validamos si la lista de ids de tallas es nula o vacía, para indicar que no se han seleccionado tallas
            // No se han seleccionado tallas
        } else {
            for (Integer idTalla : idsTalla) {                                                  // recorre las id de tallas para asignarlas a la lista de idsTalla para traer la talla real desde la BD.

                RopaTalla ropaTalla = null;                                                     // Variable que almacena la relacion entre Ropa y Talla para asignar la talla a la ropa.
                ropaTalla = new RopaTalla();                                                    // Inicialización de la variable de tipo RopaTalla para crear la relacion entre Ropa y Talla.   

                Talla talla = null;                                                             // Variable que almacena la talla real desde la BD para asignarla a la ropa.
                talla = tallaServicio.buscarTallaPorId(idTalla);                                // Traemos la talla real desde la BD por su id para asignarla a la ropa.

            if (talla != null) {                                                                // Validamos si la talla existe en la BD, si es así, asignamos la talla a la ropa.

                // Llave Primaria 'PK' para la tabla intermedia 'RopaTalla'
                RopaTallaPK llavePrimaria = null;                                               // Variable que almacena la llave compuesta para la tabla intermedia RopaTalla para asignar la relacion entre Ropa y Talla.

                llavePrimaria = new RopaTallaPK();                                              // Inicialización de la variable de tipo RopaTallaPK para crear la llave compuesta.
                llavePrimaria.setIdTalla(idTalla);                                              // Asignamos el id de talla a la llave primaria (llave compuesta).

                ropaTalla.setId(llavePrimaria);                                                 // Asignamos la llave primaria (llave compuesta) a la tabla intermedia RopaTalla.
                ropaTalla.setRopa(ropa);                                                        // Creamos la relacion muchos a muchos entre Ropa y Talla 
                ropaTalla.setTalla(talla);                                                      // Creamos la relacion muchos a muchos entre Ropa y Talla 

                ropa.getTallasAsignadas().add(ropaTalla);                                       // Agregamos a la lista de RopaTalla de ropa para asignar la talla a la ropa.
                }
            }
        }
        ropaServicio.guardarRopas(ropa);                                                        // Guardamos los datos de Ropa que recibimos del formulario del registro.
        modelAndView.setViewName("redirect:/ropa");                                   // Definimos la vista para redireccionar a la lista de Ropa después de guardar un nuevo registro.    

        return modelAndView;
    } // Funcion que guarda un nuevo registro de Ropa (BOTTOM)

    @PostMapping("/editar") // Funcion que edita un registro de Ropa (TOP)
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista Ropa.

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("ropa/formulario");                                  // Asignamos la vista de nuestro formulario para editar el registro seleccionado.

        modelAndView.addObject("ropa", ropaServicio.buscarRopasPorId(id));       // Obtenemos y asignamos el registro de Ropa por su id para el formulario de Ropa.
        modelAndView.addObject("productos", productoServicio.obtenerProductos());// Obtenemos y agregamos la lista de Datos de productos para el formulario de Ropa.
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());      // Obtenemos y agregamos la lista de Datos de origen para el formulario de Ropa.
        modelAndView.addObject("tallas", tallaServicio.obtenerTallas());         // Obtenemos y agregamos la lista de Datos de tallas para el formulario de Ropa.

        return modelAndView;
    } // Funcion que edita un registro de Ropa (BOTTOM)

    @PostMapping("/eliminar") // Funcion que elimina un registro de Ropa (TOP)
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                                      // Variable que almacena las operaciones de la vista Ropa.  

        modelAndView = new ModelAndView();                                                     // Inicialización de la variable de tipo ModelAndView
        ropaServicio.eliminarRopasPorId(id);                                                   // Metodo para Eliminar el registro de Ropa por su id

        modelAndView.setViewName("redirect:/ropa");                                  // Definimos la vista para redireccionar a la lista de Ropa después de eliminar un registro

        return modelAndView;
    } // Funcion que elimina un registro de Ropa (BOTTOM)
}