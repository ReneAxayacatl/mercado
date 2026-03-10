package com.rene.mercado.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "caduce", schema = "rene")
public class Caduce {
    
    @Id
    @Column(name = "id_caduce")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCaduce;

    @Column(name = "caduce")
    private String Caduce;
}
