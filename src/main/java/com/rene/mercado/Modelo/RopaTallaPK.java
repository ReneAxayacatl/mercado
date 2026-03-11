package com.rene.mercado.Modelo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode  //otra forma de definirlo pero @Data ya implementa equals y hashcode
@NoArgsConstructor  //otra forma de definir contructor vacio - @Data ya lo incluye
public class RopaTallaPK implements Serializable{

    private Integer idRopa;
    private Integer idTalla;

    // @Data ya incluye: Getters, setters, equals() y hashCode()
}
