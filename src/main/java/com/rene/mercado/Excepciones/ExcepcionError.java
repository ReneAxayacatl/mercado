package com.rene.mercado.Excepciones;

import java.util.Date;

import lombok.Data;

@Data
public class ExcepcionError {

    private String mensaje;     
    private String error;       
    private int estado;         
    private Date fecha;         
    private String URI;         

}
