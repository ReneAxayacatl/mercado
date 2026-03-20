package com.rene.mercado.Entidad;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data               // Omitimos la creacion de los Getter, Setters, Equals y HashCode.
@Embeddable         // Clase embebida dentro de otra clase (RopaTalla)
public class EntidadRopaTallaPK implements Serializable{

    private Integer idRopa;     // Declaramos nuestra llave compuesta idRopa
    private Integer idTalla;    // Declaramos nuestra llace compuesta idTalla
}
