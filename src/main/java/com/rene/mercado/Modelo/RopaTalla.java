package com.rene.mercado.Modelo;

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
public class RopaTalla {

    @EmbeddedId                     // Define nuestra PK como llave compuesta de nuestra clase embebida 'RopaTallaPK'
    private RopaTallaPK id;

    @ManyToOne                      // Relacion Muchos a Uno con Ropa
    @MapsId("idRopa")               // Mapea y establece conexion con la Tabla Ropa (id_ropa).
    @JoinColumn(name = "id_ropa")
    private Ropa ropa;

    @ManyToOne                      // Relacion Muchos a Uno con Talla
    @MapsId("idTalla")              // Mapea y establece conexion con la Tabla Talla (id_talla).
    @JoinColumn(name = "id_talla")
    private Talla talla;
}
