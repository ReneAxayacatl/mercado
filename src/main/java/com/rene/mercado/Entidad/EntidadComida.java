package com.rene.mercado.Entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "comida", schema = "rene")                                    // Anotacion para definir la tabla y el esquema al que pertenece

public class EntidadComida {
    @Id                                                                     // Anotacion para identificar la llave primaria de la entidad comida
    @GeneratedValue(strategy = GenerationType.IDENTITY)                     // Anotacion para definir el dato auto-incremental a la llave primaria
    @Column(name = "id_comida")                                             // Anotacion para definir el Id de la columna en la base de datos
    private Integer idComida;                                               // Variable para manejar el Id de comida de la BD

    @ManyToOne(fetch = FetchType.LAZY)                                      // Anotacion que apuntamos a la relacion de muchos a uno entre Comida y Producto, y carga los datos de la entidad principal (LAZY)
    @JoinColumn(name = "id_producto")                                       // Anotacion para referirnos a la llave foranea que se relaciona con la tabla comida
    private EntidadProductos producto;                                      // Variable para almacenar los datos de producto asociado a comida

    @ManyToMany(fetch = FetchType.LAZY)                                     // Anotacion para hacer referencia la relacion de muchos a uno entre comida y origen y cargar los datos de la entidad principal (LAZY)
    @JoinTable(                                                             // Anotacion para apuntar la union entre una tabla intermedia, entre el contexto de dos entidades de comida y origen.
            name="comida_origen",
            schema="rene",
            joinColumns=@JoinColumn(name="id_comida"),                      // Parametro para hacer referencia a la entidad comida con la llave forane id_comida.
            inverseJoinColumns=@JoinColumn(name="id_origen")                // Parametro para hacer referencia a la columna de la llave foranea de la tabla intermedia que apunta al objeto del otro lado de la relación.
    )
    private List<EntidadOrigen> origenes = new ArrayList<>();               // lista inicializada vacía para almacenar los objetos EntidadOrigen relacionados o asociados a comida.
}
