package com.rene.mercado.Entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "origen", schema = "rene")

public class EntidadOrigen {
    
    @Id                                                     // Anotacion para identificar lalve primaria de la entidad 'origen'
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Anotacion para definir el dato auto-incremental a la llave primaria
    @Column(name = "id_origen")                             // Anotacion para definir el Id de la columna en la base de datos
    private Integer idOrigen;                               // Variable de tipo entero para almacenar el Id de origen.
    
    @Column(name = "nombre_origen")                         // Anotacion para definir el id de la columna en la base de datos
    private String nombreOrigen;                            // Variable para almacenar el nombre de origen 

    @ManyToMany(mappedBy = "origenes",                      // ralcion de muchos a muchos con la entidad origen 
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)                  // relacion inversa que apunta a la entidad Comida
    private List<EntidadComida> comida;

}
