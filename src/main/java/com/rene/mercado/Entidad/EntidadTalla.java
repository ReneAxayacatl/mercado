package com.rene.mercado.Entidad;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "talla", schema = "rene")

public class EntidadTalla {

    @Id                                                         // Anotacion para identificar PK de la entidad 'talla'
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // Anotacion para definir el dato auto-incremental a la llave primaria
    @Column(name = "id_talla")                                  // Anotacion para definir el Id de la columna de la base de datos de la entidad ropa
    private Integer idTalla;                                    // Variable de tipo entero que almacena el id de talla

    @NotBlank(message = "El tipo de Talla es Obligatrio") // Regla de validacion para definir que un campo es obligatorio
    @Column(name = "tipo_talla")                                // Anotacion para definir el tipo de talla de la columna en la base de datos de la entidad talla
    private String tipoTalla;                                   // variable de tipo caracter para almacenar los datos del tipo de talla

    @OneToMany(mappedBy = "talla",                              // Anotacion para definir la relacion de uno a muchos de talla a Ropa.con la entidad intermedia RopaTalla
                fetch = FetchType.LAZY, 
                cascade = CascadeType.ALL, 
                orphanRemoval = true)                                                        
    private List<EntidadRopaTalla> ropasAsignadas;              // Lista de datos que almacena las relaciones entre ropa y talla

}
