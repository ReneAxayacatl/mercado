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
        List<EntidadRopa> listaDatosRopa = null;                                                // Variable que almacena la lista de informacion registrada de Ropa

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView
        listaDatosRopa = ropaServicio.obtenerRopas();                                           // Obtener los datos registrado de Ropa.

        modelAndView.setViewName("ropa/listaRopa");                                   // Asignamos la vista de nuestra lista para visualizar los registros.
        modelAndView.addObject("listaRopa", listaDatosRopa);                     // Agregamos la lista de datos de Ropa que obtuvimos a la vista.

        return modelAndView;
    } // Funcion que muestra la lista de los registros de Ropa registrados (BOTTOM)

    @GetMapping("/nuevo") // Funcion que crea un nuevo registro de Ropa (TOP)
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista Ropa.
        modelAndView = new ModelAndView();                                                      // Variable que almacena la lista de informacion registrada de Ropa.

        modelAndView.setViewName("ropa/formularioRopa");                              // Asignamos la vista de nuestro formulario para crear nuevos registros.
        modelAndView.addObject("ropa", new EntidadRopa());                       // Creamos un nuevo registro al formulario de Ropa.
        modelAndView.addObject("productos", productoServicio.obtenerProductos());// Obtenemos y agregamos la lista de Datos de productos para el formulario de Ropa.
        modelAndView.addObject("origenes", origenServicio.obtenerOrigen());      // Obtenemos y agregamos la lista de Datos de origen para el formulario de Ropa.
        modelAndView.addObject("tallas", tallaServicio.obtenerTallas());         // Obtenemos y agregamos la lista de Datos de tallas para el formulario de Ropa.

        return modelAndView;
    } // Funcion que crea un nuevo registro de Ropa (BOTTOM)

//     @PostMapping("/guardar") // Funcion que guarda un nuevo registro de Ropa (TOP)
//     public ModelAndView guardar(@NonNull @ModelAttribute EntidadRopa ropa, 
//                             @RequestParam(name = "idsTalla", required = false) List<Integer> idsTalla,     // variable que almacena la lista de datos de tipo id que vengan de la Entidad Tallas
//                             @RequestParam(name = "idsOrigen", required = false) List<Integer> idsOrigen) { // variable que almacena la lista de datos de tipo id que vengan de la Entidad Origen

//     ModelAndView modelAndView = null;                                                                      // variable que almacena las operaciones de la vista Ropa.
//     modelAndView = new ModelAndView();                                                                     // Inicializacion de la vrriable de tipo ModelAndView.

//                                                                                                             // Inicializamos la lista de tallas asignadas
//     ropa.setTallasAsignadas(new ArrayList<>());                                                             // asiganmos un arreglo de listas apra los datos que vengan a ropa

//     // Asignar tallas
//     if (idsTalla != null) {                                                                                 // validamos que exista un dato en la llave primaria de la tabla intermedia de ropa -> talla
//         for (Integer idTalla : idsTalla) {                                                                  // rrecoremos y asiganmos cada id que venga de talla hacia nuestra llave primaria para la columna idsTalla

//             EntidadTalla talla = null;                                                                      // variable que almacena las operaciones para nuestra entidad talla para el registro de datos en ropa
//             talla = tallaServicio.buscarTallaPorId(idTalla);                                                // variable que almacena los registro de busqueda de talla por id
//             if (talla != null) {                                                                            // validacion de que exista una talla

//                 boolean existe = false;                                                                     // Verificar manualmente si ya existe la relación
//                 for (EntidadRopaTalla ropaTallaExistente : ropa.getTallasAsignadas()) {                     // asignacion de datos traidos a nuestro arreglo de ropa por cada relacion que existe con talla (tabla intermedia RopaTalla)
//                     if (ropaTallaExistente.getTalla().getIdTalla().equals(idTalla)) {                       // validacion para traer aquellas tallas que concuerdes con su id de su entidad Talla
//                         existe = true;                                                                      // Varificar que ahora ya existe una relacion con datos
//                         break;
//                     }
//                 }

//                 if (existe == false) {                                                                      // varificar que no exista un registro o dato
//                     EntidadRopaTalla ropaTalla = null;                                                      // variable que creara la relacion entre ropa y talla 
//                     EntidadRopaTallaPK llavePrimaria = null;                                                // variable para la llave primaria compuesta (idRopa + idTalla)

//                     ropaTalla = new EntidadRopaTalla();                                                     // variable para almacena el obejto de la entidad intermedia RopaTalla
//                     llavePrimaria = new EntidadRopaTallaPK();                                               // variable que almacena la llave compuesta

//                     llavePrimaria.setIdRopa(ropa.getIdRopa());                                              // asignamos nuestra id de ropa a nuestra llave compuesta 
//                     llavePrimaria.setIdTalla(idTalla);                                                      // asiganmos nuestra id de talla a nuestra llave compuesta 
//                     ropaTalla.setId(llavePrimaria);                                                         // asignamos las llaves compuestas a nuestro objeto de entidad intermedia (RopaTalla)
//                     ropaTalla.setRopa(ropa);                                                                // asiganmos la relacion de Muchos a Uno a la entidad Ropa
//                     ropaTalla.setTalla(talla);                                                              // asiganmos la relacion de Muchos a Uno a la entidad Talla
//                     ropa.getTallasAsignadas().add(ropaTalla);                                               // Agregamos esta relación a la lista de tallas de la ropa
//                 }
//             }
//         }
//     }

//     ropa.setOrigenes(new ArrayList<>());                                                                    // Inicializamos la lista de origenes asignados
//     if (idsOrigen != null) {                                                                                // Verificamos que sí se hayan enviado IDs de origen desde el formulario y que eisten
//         for (Integer id : idsOrigen) {                                                                      // recorremos cada id de Origen seleccionado 
//             EntidadOrigen origen = null;                                                                    // variable para almacenar el origen encontrado
//             origen = origenServicio.buscarOrigenPorId(id);                                                  // asignamos los datos de otigen buscados por su id.
//             if (origen != null) ropa.getOrigenes().add(origen);                                             // Si el origen existe, lo agregamos a la lista de orígenes de la ropa
//         }
//     }
//     ropaServicio.guardarRopas(ropa);                                                                        // Guardar ropa (tanto nueva como editada)
//     modelAndView.setViewName("redirect:/ropa");                                                   // Redireccionar a la lista de Ropa después de guardar un registro
//     return modelAndView;
// } // Funcion que guarda un nuevo registro de Ropa (BOTTOM)
    @PostMapping("/guardar")
    public ModelAndView guardar(@ModelAttribute EntidadRopa ropa,
                                @RequestParam(required = false) List<Integer> idsTalla,
                                @RequestParam(required = false) List<Integer> idsOrigen) {
        ModelAndView modelAndView = new ModelAndView();
        // ropaServicio.guardarRopas(ropa); // JPA se encarga de manejar relaciones y duplicados
        ropaServicio.guardarCompleto(ropa, idsTalla, idsOrigen);
        modelAndView.setViewName("redirect:/ropa");
        return modelAndView;
    }

    @PostMapping("/editar") // Funcion que edita un registro de Ropa (TOP)
    public ModelAndView editar(@NonNull @RequestParam Integer id) {

        ModelAndView modelAndView = null;                                                       // Variable que almacena las operaciones de la vista Ropa.

        modelAndView = new ModelAndView();                                                      // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("ropa/formularioRopa");                              // Asignamos la vista de nuestro formulario para editar el registro seleccionado.

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