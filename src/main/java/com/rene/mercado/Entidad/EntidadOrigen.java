package com.rene.mercado.Entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "origen", schema = "rene")                    // Anotacion para definir la tabla y el esquema al que pertenece

public class EntidadOrigen {
    
    @Id                                                     // Anotacion para identificar la llave primaria de la entidad origen
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Anotacion para definir el dato auto-incremental a la llave primaria
    @Column(name = "id_origen")                             // Anotacion para definir el Id de la columna en la base de datos
    private Integer idOrigen;                               // Variable para manejar el Id de origen de la BD
    
    @Column(name = "nombre_origen")                         // Anotacion para definir el nombre de origen de la columna en la base de datos
    private String nombreOrigen;                            // Variable para manejar el nombre de la origen

    @ManyToMany(mappedBy = "origenes",                      // Anotacion que indica que la relación está controlada desde la otra clase (comida), y no desde esta
                fetch = FetchType.LAZY,                     // parametro para cargar primero los datos de la entidad principal (LAZY)
                cascade = CascadeType.ALL)                  
    private List<EntidadComida> comida;                     // lista para almacenar los objetos EntidadComida relacionados o asociados a origen

}
