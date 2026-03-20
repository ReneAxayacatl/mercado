package com.rene.mercado.Entidad;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity                             // Definimos nuestra clase como Entidad.
@Table(name = "ropa_talla", schema = "rene") //Representamos nuestra entidad de la Tabla 'ropa_talla' y esquema 'rene'
public class EntidadRopaTalla {

    @EmbeddedId                     // Define nuestra PK como llave compuesta de nuestra clase embebida 'RopaTallaPK'
    private EntidadRopaTallaPK id;

    @ManyToOne                      // Relacion Muchos a Uno con Ropa
    @MapsId("idRopa")               // Mapea y establece conexion con la Tabla Ropa (id_ropa).
    @JoinColumn(name = "id_ropa")   // Anotacion para definir la llave foranea de la columna en la BD que se relaciona con la entidad Ropa
    private EntidadRopa ropa;       // Variable de tipo ropa asociado con la entidad Ropa

    @ManyToOne                      // Relacion Muchos a Uno con Talla
    @MapsId("idTalla")              // Mapea y establece conexion con la Tabla Talla (id_talla).
    @JoinColumn(name = "id_talla")  // Anotacion para definir la llave foranea de la columna en la BD que se relaciona con la entidad Talla
    private EntidadTalla talla;     // Variable de tipo ropa asociado con la entidad Talla
}
