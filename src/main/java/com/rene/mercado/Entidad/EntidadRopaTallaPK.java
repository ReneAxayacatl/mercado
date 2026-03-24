package com.rene.mercado.Entidad;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable         // Clase embebida dentro de otra clase (RopaTalla)
public class EntidadRopaTallaPK implements Serializable{

    private Integer idRopa;     // Declaramos nuestra llave compuesta idRopa
    private Integer idTalla;    // Declaramos nuestra llace compuesta idTalla

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntidadRopaTallaPK)) return false;
        EntidadRopaTallaPK that = (EntidadRopaTallaPK) o;
        return Objects.equals(idRopa, that.idRopa) && Objects.equals(idTalla, that.idTalla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRopa, idTalla);
    }
}
