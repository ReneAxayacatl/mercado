package com.rene.mercado.Modelo;

import java.util.List;

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

    @ManyToMany(mappedBy = "origenes", 
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)       // relacion inversa que apunta a la entidad Comida
    private List<Comida> comida;

}
