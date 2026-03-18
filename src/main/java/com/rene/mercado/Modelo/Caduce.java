package com.rene.mercado.Modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "caduce", schema = "rene")                                        // Anotacion para definir la tabla en la base de datos y el esquema al que pertenece
public class Caduce {

    @Id                                                                         // Anotacion para identificar PK de la entidad 'caduce'
    @Column(name = "id_caduce")                                                 // Anotacion para definir el Id de la columna en la base de datos
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCaduce;                                                   // Variable de tipo entero para almacenar el Id del caduce

    @Column(name = "caduce")                                                    // Anotacion para definir el nombre de la columna en la base de datos
    private String caduce;                                                      // Variable de tipo cadena(String) para almacenar el tipo de caducidad

    @OneToMany(mappedBy = "caduce", cascade = CascadeType.ALL, orphanRemoval = true)// Anotacion para definir la relacion de uno a muchos entre Caduce y Categoria
    private List<Categoria> categorias;                                         // Lista de datos de las categorias asociadas a un caduce
}
