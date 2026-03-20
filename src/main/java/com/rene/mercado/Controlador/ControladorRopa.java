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

import com.rene.mercado.Entidad.EntidadOrigen;
import com.rene.mercado.Entidad.EntidadRopa;
import com.rene.mercado.Entidad.EntidadRopaTalla;
import com.rene.mercado.Entidad.EntidadRopaTallaPK;
import com.rene.mercado.Entidad.EntidadTalla;
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
        List<EntidadRopa> listaDatosRopa = null;                                                       // Variable que almacena la lista de informacion registrada de Ropa

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView
        listaDatosRopa = ropaServicio.obtenerRopas();                                           // Obtener los datos registrado de Ropa.

        modelAndView.setViewName("ropa/listaRopa");                                       // Asignamos la vista de nuestra lista para visualizar los registros.
        modelAndView.addObject("listaRopa", listaDatosRopa);                     // Agregamos la lista de datos de Ropa que obtuvimos a la vista.

        return modelAndView;
    } // Funcion que muestra la lista de los registros de Ropa registrados (BOTTOM)

    @GetMapping("/nuevo") // Funcion que crea un nuevo registro de Ropa (TOP)
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista Ropa.
        modelAndView = new ModelAndView();                                                      // Variable que almacena la lista de informacion registrada de Ropa.

        modelAndView.setViewName("ropa/formularioRopa");                                  // Asignamos la vista de nuestro formulario para crear nuevos registros.
        modelAndView.addObject("ropa", new EntidadRopa());                              // Creamos un nuevo registro al formulario de Ropa.
        modelAndView.addObject("productos", productoServicio.obtenerProductos());// Obtenemos y agregamos la lista de Datos de productos para el formulario de Ropa.
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());      // Obtenemos y agregamos la lista de Datos de origen para el formulario de Ropa.
        modelAndView.addObject("tallas", tallaServicio.obtenerTallas());         // Obtenemos y agregamos la lista de Datos de tallas para el formulario de Ropa.

        return modelAndView;
    } // Funcion que crea un nuevo registro de Ropa (BOTTOM)

    @PostMapping("/guardar") 
public ModelAndView guardar(@NonNull @ModelAttribute EntidadRopa ropa, 
                            @RequestParam(name = "idsTalla", required = false) List<Integer> idsTalla, 
                            @RequestParam(name = "idsOrigen", required = false) List<Integer> idsOrigen) {

    ModelAndView modelAndView = new ModelAndView();

    // Inicializamos la lista de tallas asignadas
    ropa.setTallasAsignadas(new ArrayList<>());

    // Asignar tallas
    if (idsTalla != null) {
        for (Integer idTalla : idsTalla) {
            EntidadTalla talla = tallaServicio.buscarTallaPorId(idTalla);
            if (talla != null) {

                // Verificar manualmente si ya existe la relación
                boolean existe = false;
                for (EntidadRopaTalla rtExistente : ropa.getTallasAsignadas()) {
                    if (rtExistente.getTalla().getIdTalla().equals(idTalla)) {
                        existe = true;
                        break;
                    }
                }

                if (!existe) {
                    EntidadRopaTalla rt = new EntidadRopaTalla();
                    EntidadRopaTallaPK pk = new EntidadRopaTallaPK();
                    pk.setIdRopa(ropa.getIdRopa());  // Muy importante
                    pk.setIdTalla(idTalla);
                    rt.setId(pk);
                    rt.setRopa(ropa);
                    rt.setTalla(talla);
                    ropa.getTallasAsignadas().add(rt);
                }
            }
        }
    }

    // Asignar origenes
    ropa.setOrigenes(new ArrayList<>());
    if (idsOrigen != null) {
        for (Integer id : idsOrigen) {
            EntidadOrigen o = origenServicio.buscarOrigenPorId(id);
            if (o != null) ropa.getOrigenes().add(o);
        }
    }

    // Guardar ropa (tanto nueva como editada)
    ropaServicio.guardarRopas(ropa);

    modelAndView.setViewName("redirect:/ropa");
    return modelAndView;
} // Funcion que guarda un nuevo registro de Ropa (BOTTOM)

    @PostMapping("/editar") // Funcion que edita un registro de Ropa (TOP)
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista Ropa.

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("ropa/formularioRopa");                                  // Asignamos la vista de nuestro formulario para editar el registro seleccionado.

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