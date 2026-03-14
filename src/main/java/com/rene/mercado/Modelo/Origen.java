package com.rene.mercado.Modelo;

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

    // @OneToMany(mappedBy = "comida", 
    //             fetch = FetchType.LAZY,
    //             cascade = CascadeType.ALL, 
    //             orphanRemoval = true)       // relacion inversa que apunta a la entidad Comida
    // private List<Comida> comida;

}
