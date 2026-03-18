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

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Modelo.Categoria;
import com.rene.mercado.Servicio.ServicioCaduce;
import com.rene.mercado.Servicio.ServicioCategoria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller                                                         // Componente que regresa nuestras peticiones con vista Thymeleaf y ModelAndView
@CrossOrigin(origins = "*", methods = {                             // Anotacion para manejar peticiones completas CRUD
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.PUT,
})
@RequestMapping("/categoria")                                       // Ruta global base que manejara toda la clase ControladorCategoria 
public class ControladorCategoria {

    @Autowired
    private ServicioCategoria categoriaService;                     // Inyeccion de la dependencia servicio categoria para usar sus metodos definidos
    @Autowired
    private ServicioCaduce caduceService;                           // Inyeccion de la dependencia servicio caduce para usar sus metodos definidos

    @GetMapping // Funcion que muestra la lista de los registros de categoria registrados (TOP)
    public ModelAndView listar() {

        ModelAndView modelAndView = null;                           // Variable que almacena las operaciones de la vista categorias
        List<Categoria> listaDatosCategorias = null;                // Variable que almacena la lista de informacion registrada de categoria.

        modelAndView = new ModelAndView();                          // Inicialización de la variable de tipo ModelAndView
        listaDatosCategorias = categoriaService.obtenerCategorias();// Obtener los datos registrado de categorias.

        modelAndView.setViewName("categorias/lista");               // Asignamos la vista de nuestra lista para visualizar los registros.
        modelAndView.addObject("categorias", listaDatosCategorias); // Obtenemos la lista de Categoria para nuestro atributo categorias.

        return modelAndView;
    } // Funcion que muestra la lista de los registros de categoria registrados (BOTTOM)

    @GetMapping("/nuevo")// Funcion que crea un nuevo registro de categoria (TOP)
    public ModelAndView nuevo() {

        ModelAndView modelAndView = null;                           // Variable que almacena las operaciones de la vista categorias

        modelAndView = new ModelAndView();                          // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("categorias/formulario");          // Asignamos la vista de nuestro formulario para crear nuevos registros.

        modelAndView.addObject("categorias", new Categoria());      // Creamos un nuevo registro al formulario de categoria para el atributo categorias.
        modelAndView.addObject("caduces", caduceService.obtenerCaduce());// Obtenemos la listad de Datos de caduce para el formulario de categoria..

        return modelAndView;
    } // Funcion que crea un nuevo registro de categoria (BOTTOM)

    @PostMapping("/guardar") // Funcion que guarda un nuevo registro de categoria
    public ModelAndView guardar(@NonNull @ModelAttribute Categoria categoria) {

        ModelAndView modelAndView = null;                           // Variable que almacena las operaciones de la vista categorias
    
        modelAndView = new ModelAndView();                          // Inicialización de la variable de tipo ModelAndView
        categoriaService.guardarCategorias(categoria);              // Guardamos el objeto categoria que recibimos del formulario de los registros a través del servicio categoriaService

        modelAndView.setViewName("redirect:/categoria");            // Definimos la vista para redireccionar a la lista de los registros de categoria después de guardar un nuevo registro

        return modelAndView;
    } // Funcion que guarda un nuevo registro de categoria (BOTTOM)

    @PostMapping("/editar") // Funcion que edita un registro de categoria (TOP)
    public ModelAndView editar(@NonNull @RequestParam Integer id) {
        
        ModelAndView modelAndView = null;                           // Variable que almacena las operaciones de la vista categorias

        modelAndView = new ModelAndView();                          // Inicialización de la variable de tipo ModelAndView
        modelAndView.setViewName("categorias/formulario");          // Asignamos la vista de nuestro formulario para editar el registro seleccionado.

        modelAndView.addObject("categorias", categoriaService.buscarCategoriasPorId(id));// Obtenemos y asignamos el registro de categoria por su id para el formulario de categoria.
        modelAndView.addObject("caduces", caduceService.obtenerCaduce());               // Obtenemos la listad de Datos de caduce para el formulario de categoria.

        return modelAndView;
    } // Funcion que edita un registro de categoria (BOTTOM)

    @PostMapping("/eliminar") // Funcion que elimina un registro de categoria (TOP)
    public ModelAndView eliminar(@NonNull @RequestParam Integer id) {

        categoriaService.eliminarCategoriasPorId(id);               // Eliminamos el registro de categoria por su id a traves del metodo inyectado de categoriaService

        ModelAndView modelAndView = null;                           // Variable que almacena las operaciones de la vista categorias
        modelAndView = new ModelAndView();                          // Inicialización de la variable de tipo ModelAndView

        modelAndView.setViewName("redirect:/categoria");            // Definimos la vista para redireccionar a la lista de los registros de categoria después de eliminar un registro

        return modelAndView;
    } // Funcion que elimina un registro de categoria (BOTTOM)
}
