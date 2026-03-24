package com.rene.mercado.Entidad;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity                             
@Table(name = "ropa_talla", schema = "rene")                // Anotacion para definir la tabla y el esquema al que pertenece
public class EntidadRopaTalla {

    @EmbeddedId                                             // Anotacion que define una llave compuesta, por mas campos
    private EntidadRopaTallaPK id;

    @ManyToOne                                              // Anotacion que apuntamos a la relacion de muchos a uno entre ropa y talla
    @MapsId("idRopa")                                       // Mapea y establece conexion con la Tabla Ropa (id_ropa).
    @JoinColumn(name = "id_ropa")                           // Anotacion para definir la llave foranea de la columna en la BD que se relaciona con la entidad Ropa
    private EntidadRopa ropa;                               // Variable que es asociado con la entidad Ropa

    @ManyToOne                                              // Anotacion que apuntamos a la relacion de muchos a uno entre ropa y talla
    @MapsId("idTalla")                                      // Mapea y establece conexion con la Tabla talla (id_talla).
    @JoinColumn(name = "id_talla")                          // Anotacion para definir la llave foranea de la columna en la BD que se relaciona con la entidad Talla
    private EntidadTalla talla;                             // Variable que es asociado con la entidad Talla

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntidadRopaTalla)) return false;
        EntidadRopaTalla that = (EntidadRopaTalla) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
