package com.rene.mercado.Entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "categoria", schema = "rene")                                     // Anotacion para definir la tabla y el esquema al que pertenece

public class EntidadCategoria {
    @Id                                                                         // Anotacion para identificar la llave primaria de la entidad categoria
    @GeneratedValue(strategy = GenerationType.IDENTITY)                         // Anotacion para definir el dato auto-incremental a la llave primaria
    @Column(name = "id_categoria")                                              // Anotacion para definir el Id de la columna en la base de datos
    private Integer idCategoria;                                                // Variable para manejar el Id de la categoria de la BD

    @Column(name = "nombre_categoria")                                          // Anotacion para definir el nombre de la categoria de la columna en la base de datos
    private String nombreCategoria;                                             // Variable para manejar el nombre de la categoria

    @ManyToOne(fetch = FetchType.LAZY)                                          // Anotacion que apuntamos a la relacion de muchos a uno entre Categoria y Caduce, y carga los datos de la entidad principal (LAZY)
    @JoinColumn(name = "id_caduce")                                             // Anotacion para referirnos a la llave foranea que se relaciona con la tabla caduce
    private EntidadCaduce caduce;                                               // Variable para almacenar los datos de caduce asociado a una categoria

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)               // Anotacion que indica que la relación está controlada desde la otra clase (Producto), y no desde esta
    private List<EntidadProductos> productos;                                   // lista para almacenar los objetos EntidadProductos relacionados o asociados a categoria
}
