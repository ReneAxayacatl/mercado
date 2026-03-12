package com.rene.mercado.Excepciones;

import java.util.Date;

import lombok.Data;

@Data
public class ExcepcionError {

    private String mensaje;     // Da el mensaje de la Escepcion
    private String error;       // Da el 
    private int estado;
    private Date fecha;
    private String URI;

}
