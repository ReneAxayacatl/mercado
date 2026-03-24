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

import com.rene.mercado.Entidad.EntidadCategoria;
import com.rene.mercado.Servicio.ServicioCaduce;
import com.rene.mercado.Servicio.ServicioCategoria;

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
@RequestMapping("/categoria")                                                           // Permite gestionar operaciones relacionadas con Categoria.
public class ControladorCategoria {

    @Autowired
    private ServicioCategoria categoriaService;                                         // Variable que almacena las operaciones definidas para el contexto de categoria.
    @Autowired
    private ServicioCaduce caduceService;                                               // Variable que almacena las operaciones definidas para el contexto de caducidad.

    @GetMapping 
    public ModelAndView listar() {
        // Funcion que muestra la lista de los datos registros de categoria (TOP)
        ModelAndView modelAndView = null;                                               // Variable que almacena las operaciones de la vista categoria.
        List<EntidadCategoria> listaDatosCategorias = null;                             // Variable que almacena la lista de informacion registrada de categoria.

        modelAndView = new ModelAndView();                                              // Inicialización de la variable que almacena el objeto ModelAndView de la lista categoria.
        listaDatosCategorias = categoriaService.obtenerCategorias();                    // Almacenamos los datos de la lista que obtuvimos de categoria.

        modelAndView.setViewName("categorias/listaCategoria");                // Se define la direccion de la vista categoria.
        modelAndView.addObject("categorias", listaDatosCategorias);      // Agregamos la lista con los datos obtenidos a la vista. 

        return modelAndView;
    }// Funcion que muestra la lista de los datos registros de categoria (BOTTOM)

    @GetMapping("/nuevo")
    public ModelAndView nuevo() {
        // Funcion que crea un nuevo registro de categoria (TOP)
        ModelAndView modelAndView = null;                                               // Variable que almacena las operaciones de la vista categoria

        modelAndView = new ModelAndView();                                              // Inicialización de la variable que almacena el objeto ModelAndView para un nuevo registo categoria.
        modelAndView.setViewName("categorias/formularioCategoria");           // Definimos la direccion del formulario con los datos del contexto a nuestra vista categoria

        modelAndView.addObject("categorias", new EntidadCategoria());    // Agregamos un nuevo registro para nuestro contexto de categoria.
        modelAndView.addObject("caduces", caduceService.obtenerCaduce());// Agregamos la lista de Datos de nuestros contexto caduce para la categoria..

        return modelAndView;
    } // Funcion que crea un nuevo registro de categoria (BOTTOM)

    @PostMapping("/guardar") 
    public ModelAndView guardar(@NonNull @ModelAttribute EntidadCategoria categoria) {
        // Funcion para guardar un nuevo registro de categoria (TOP)
        ModelAndView modelAndView = null;                                               // Variable que almacena las operaciones de la vista categorias
    
        modelAndView = new ModelAndView();                                              // Inicialización de la variable que almacena el objeto ModelAndView de categoria.
        categoriaService.guardarCategorias(categoria);                                  // Guarda los datos de categoria en la base de datos

        modelAndView.setViewName("redirect:/categoria");                      // Definimos la redireccion a la lista de los registros de categoria.

        return modelAndView;
    } // Funcion para guardar un nuevo registro de categoria (BOTTOM)

    @PostMapping("/editar") 
    public ModelAndView editar(@NonNull @RequestParam Integer id) {
        // Funcion que edita un registro de categoria (TOP)
        ModelAndView modelAndView = null;                                               // Variable que almacena las operaciones de la vista categorias

        modelAndView = new ModelAndView();                                              // Inicialización de la variable que almacena el objeto ModelAndView de categoria.
        modelAndView.setViewName("categorias/formularioCategoria");           // Definimos la direccion del formulario con los datos del contexto a nuestra vista categoria.

        modelAndView.addObject("categorias", categoriaService.buscarCategoriasPorId(id));// Agregamos los datos que se obtuvieron por el Id correspondiente de categoria.
        modelAndView.addObject("caduces", caduceService.obtenerCaduce());                // Agregamos la lista de Datos de nuestros contexto caduce para la categoria..

        return modelAndView;
    } // Funcion que edita un registro de categoria (BOTTOM)

    @PostMapping("/eliminar") 
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {
        // Funcion que elimina los registro de categoria (TOP)
        ModelAndView modelAndView = null;                                               // Variable que almacena las operaciones de la vista categorias
        
        modelAndView = new ModelAndView();                                              // Inicialización de la variable que almacena el objeto ModelAndView de categoria.
        categoriaService.eliminarCategoriasPorId(id);                                   // Eliminamos el registro de categoria por el ID correspondiente en la base de datos.

        modelAndView.setViewName("redirect:/categoria");                      // Definimos para redireccionar a la lista de los registros de categoria.

        return modelAndView;
    } // Funcion que elimina los registro de categoria (BOTTOM)
}
