package com.rene.mercado.Entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "comida", schema = "rene")

public class EntidadComida {
    @Id                                                                     // Anotacion para identificar PK de la entidad 'comida'
    @GeneratedValue(strategy = GenerationType.IDENTITY)                     // Anotacion para definir el dato auto-incremental a la PK
    @Column(name = "id_comida")                                             // Anotacion para definir el id de la columna en la BD
    private Integer idComida;                                               // variable de tipo entero para almacenar el id de comida

    @ManyToOne(fetch = FetchType.LAZY)                                      // Anotacion para definir la relacion de muchos a uno entre comida y producto y traer de forma secuencial (LAZY)
    @JoinColumn(name = "id_producto")                                       // Anotacion para definir la llave foranea de la columna en la BD que se relaciona con la tabla 'producto'
    private EntidadProductos producto;                                      // variable de tipo producto para almacenar los datos de productos asociados a una comida.

    @ManyToMany(fetch = FetchType.LAZY)                                     // Anotacion para definir la relacion de muchos a uno entre comida y origen y traer de forma secuencial (LAZY)
    @JoinTable(                                                             // Anotacion para realizar union con la entidad intermedia comida_origen para la relacion de Muchos a Muchos.
            name="comida_origen",
            schema="rene",
            joinColumns=@JoinColumn(name="id_comida"),
            inverseJoinColumns=@JoinColumn(name="id_origen")
    )
    private List<EntidadOrigen> origenes;                                   // Lista de objetos EntidadOrigen asociados a comida.
}
