package com.rene.mercado.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "talla", schema = "rene")

public class Talla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talla")
    private Integer idTalla;

    @Column(name = "tipo_talla")
    private String tipoTalla;
}
