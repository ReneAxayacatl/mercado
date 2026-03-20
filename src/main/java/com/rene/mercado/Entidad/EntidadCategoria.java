package com.rene.mercado.Entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "categoria", schema = "rene")                                     // Anotacion para definir la tabla en la base de datos y el esquema al que pertenece

public class EntidadCategoria {
    @Id                                                                         // Anotacion para identificar PK de la entidad 'categoria'
    @GeneratedValue(strategy = GenerationType.IDENTITY)                         // Anotacion para definir el dato auto-incremental a la PK
    @Column(name = "id_categoria")                                              // Anotacion para definir el Id de la columna en la base de datos
    private Integer idCategoria;                                                // Variable de tipo entero para almacenar el Id de la categoria

    @Column(name = "nombre_categoria")                                          // Anotacion para definir el nombre de categoria de la columna en la base de datos
    private String nombreCategoria;                                             // Variable de tipo String para almacenar el nombre de la categoria

    @ManyToOne(fetch = FetchType.LAZY)                                          // Anotacion para definir la relacion de muchos a uno entre Categoria y Caduce, y traer datos de forma secuencial (LAZY)
    @JoinColumn(name = "id_caduce")                                             // Anotacion para definir la llave foranea de la columna en la BD que se relaciona con la tabla 'caduce'
    private EntidadCaduce caduce;                                               // Variable de tipo Caduce para almacenar los datos de caduce asociado a una categoria

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)               // Anotacion para definir la relacion de uno a muchos entre Categoria y Productos
    private List<EntidadProductos> productos;                                   // Lista de datos de los productos asociados a una categoria
}
