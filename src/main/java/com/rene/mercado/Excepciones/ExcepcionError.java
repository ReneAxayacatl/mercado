package com.rene.mercado.Excepciones;

import java.util.Date;

import lombok.Data;

@Data
public class ExcepcionError {

    private String mensaje;     // para asignar el mensaje de error
    private String error;       // para asignar la cadena de erorres
    private int estado;         // muestra el tipo de error (Ejemplo: 400, 404, 500, etc...)
    private Date fecha;         // muestra la fecha que se genero el error
    private String URI;         // muestra la Uri del error

}
