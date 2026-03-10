package com.rene.mercado.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "origen", schema = "rene")

public class Origen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_origen")
    private Integer idOrigen;
    
    @Column(name = "nombre_origen")
    private String nombreOrigen;

}
