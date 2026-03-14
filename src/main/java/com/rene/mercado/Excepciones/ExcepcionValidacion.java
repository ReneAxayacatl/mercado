package com.rene.mercado.Excepciones;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExcepcionValidacion extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request) {

        // Construye un mensaje detallado con todos los errores
        Map<String, String> erroresDetallados = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(errorValidcaion -> erroresDetallados.put(
                errorValidcaion.getField(),
                errorValidcaion.getDefaultMessage()));

        // Crea y configura tu objeto de error personalizado
        ExcepcionError excepcionError = new ExcepcionError();
        excepcionError.setMensaje("Error en la validación de los datos proporcionados");
        excepcionError.setError("Errores: " + erroresDetallados.toString());
        excepcionError.setEstado(status.value());
        excepcionError.setFecha(new Date());
        // Obtiene la URI de la solicitud (por ejemplo: /api/tallas)
        String uri = request.getDescription(false);
        // Configura tu objeto de error
        excepcionError.setURI("URI: " + uri);

        // Devuelve la respuesta con tu objeto personalizado
        return new ResponseEntity<>(excepcionError, headers, status);
    }

}
