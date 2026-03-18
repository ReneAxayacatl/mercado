package com.rene.mercado.Excepciones;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExcepcionValidacion extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(  // Metodo para manejar errores de validacion de argumento
            @NonNull MethodArgumentNotValidException ex,            
            @NonNull HttpHeaders headers,                           // clases del modulo de Spring-web, gestiona cabeceras
            @NonNull HttpStatusCode status,                         // clases del modulo de Spring-web, gestiona codigos de estado
            @NonNull WebRequest request) {                          // clases del modulo de Spring-web, gestiona detalles de peticion original

        // Construye(mapea) un mensaje detallado con todos los errores
        Map<String, String> erroresDetallados = new HashMap<>();    // variable 'erroresDetallados' para mapear aquellos errores que salgan

        ex.getBindingResult().getFieldErrors().forEach(errorValidcaion -> erroresDetallados.put( // Traer la lista de errores y los ingresamos a 'erroresDetallados'
                errorValidcaion.getField(),
                errorValidcaion.getDefaultMessage()));

                                                                    // Crea y configura un objeto de error personalizado
        ExcepcionError excepcionError = new ExcepcionError();
        excepcionError.setMensaje("Error en la validación de los datos proporcionados");
        excepcionError.setError("Errores: " + erroresDetallados.toString());
        excepcionError.setEstado(status.value());
        excepcionError.setFecha(new Date());
                                                                    // Obtiene la URI de la solicitud (ejemplo: /api/tallas)
        String uri = request.getDescription(false);
                                                                    // Configura el Objeto de la ruta con el error
        excepcionError.setURI("URI: " + uri);

                                                                    // Devuelve la respuesta con el objeto personalizado
        return new ResponseEntity<>(excepcionError, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleNoResourceFoundException(        // Metodo para manejar errores(excepciones) 404
            @NonNull NoResourceFoundException ex,                           // Trae el mensaje del error de recurso estatico o ruta mapeada
            @NonNull HttpHeaders headers,                                   // clases del modulo de Spring-web, gestiona cabeceras
            @NonNull HttpStatusCode status,                                 // clases del modulo de Spring-web, gestiona codigos de estado
            @NonNull WebRequest request) {                                  // clases del modulo de Spring-web, gestiona detalles de peticion original

        ExcepcionError error = new ExcepcionError();
        error.setMensaje("Recurso No Encontrado");
        error.setError("La ruta no existe en el sistema" +" {"+ 
                        request.getDescription(false) + "}");
        // error.setError(ex.getMessage());
        error.setEstado(status.value());
        error.setFecha(new Date());
        error.setURI("URI: " + request.getDescription(false));
                                                                            // Devuelve la respuesta con tu objeto personalizado
        return new ResponseEntity<>(error, headers, status);
    }

}
