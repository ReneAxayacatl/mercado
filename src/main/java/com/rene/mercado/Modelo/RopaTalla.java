package com.rene.mercado.Modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ropa_talla", schema = "rene")
public class RopaTalla {

    @EmbeddedId
    private RopaTallaPK id;

    @ManyToOne
    @MapsId("idRopa")
    @JoinColumn(name = "id_ropa")
    private Ropa ropa;

    @ManyToOne
    @MapsId("idTalla")
    @JoinColumn(name = "id_talla")
    private Talla talla;
}
