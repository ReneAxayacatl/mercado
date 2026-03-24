package com.rene.mercado.Entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "caduce", schema = "rene")                                        // Anotacion para definir la tabla y el esquema al que pertenece
public class EntidadCaduce {

    @Id                                                                         // Anotacion para identificar la llave primaria de la entidad caduce
    @Column(name = "id_caduce")                                                 // Anotacion para definir el Id de la columna en la base de datos
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCaduce;                                                   // Variable para manejar el Id de caduce de la BD

    @Column(name = "caduce")                                                    // Anotacion para definir el nombre de la columna en la base de datos
    private String caduce;                                                      // Variable para manejar el tipo de caducidad de la BD

    @OneToMany(mappedBy = "caduce", cascade = CascadeType.ALL, orphanRemoval = true) // Anotacion que indica que la relación está controlada desde la otra clase (Categoria), no desde esta
    private List<EntidadCategoria> categorias;                                  // lista inicializada vacía para almacenar los objetos EntidadCategoria relacionados o asociados a caduce
}
