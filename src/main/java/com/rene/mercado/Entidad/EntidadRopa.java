package com.rene.mercado.Entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "ropa", schema = "rene")

public class EntidadRopa {

    @Id                                                     // Anotacion para identificar PK de la entidad 'ropa'
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Anotacion para definir el dato auto-incremental a la llave primaria
    @Column(name = "id_ropa")                               // Anotacion para definir el Id de la columna en la base de datos.
    private Integer idRopa;                                 // Variable de tipo entero para almacenar el id de ropa

    @ManyToOne(fetch = FetchType.LAZY)                      // Anotacion para definir la relacion de muchos a uno entre Ropa y prodcuto.
    @JoinColumn(name = "id_producto")                       // Anotacion para identificar el id de la columna de la entidad productos.
    private EntidadProductos producto;                      // Variable que almacena el prodcuto asociado a Ropa.

    @OneToMany(mappedBy = "ropa",                           // Anotacion para definir la relacion muchos a uno con la tabla intermedia RopaTalla
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL, 
                orphanRemoval = true)                       // relacion que apunta a la entidad intermedia 'RopaTalla'
    private List<EntidadRopaTalla> tallasAsignadas;

    @ManyToMany(fetch = FetchType.LAZY)                     // Anotacion para definir la relacion 
    @JoinTable(name = "ropa_origen", 
                schema = "rene", 
                joinColumns = @JoinColumn(name = "id_ropa"), 
                inverseJoinColumns = @JoinColumn(name = "id_origen"))
    private List<EntidadOrigen> origenes;                   // Lista de datos de origen asociados a Ropa
}
