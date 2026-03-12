package com.rene.mercado.Modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data               // Omitimos la creacion de los Getter, Setters, Equals y HashCode.
@EqualsAndHashCode  // Otra forma de definirlo pero @Data ya implementa equals y hashcode
@NoArgsConstructor  // Otra forma de definir contructor vacio - @Data ya lo incluye
@Embeddable         // Clase embebida dentro de otra clase (RopaTalla)
public class RopaTallaPK implements Serializable{

    private Integer idRopa;     // Declaramos nuestra llave compuesta idRopa
    private Integer idTalla;    // Declaramos nuestra llace compuesta idTalla

    // @Data ya incluye: Getters, Setters, equals() y hashCode()
}
