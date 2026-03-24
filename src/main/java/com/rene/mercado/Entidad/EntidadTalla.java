package com.rene.mercado.Entidad;

import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "talla", schema = "rene")                         // Anotacion para definir la tabla y el esquema al que pertenece

public class EntidadTalla {

    @Id                                                         // Anotacion para identificar la llave primaria de la entidad talla
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // Anotacion para definir el dato auto-incremental a la llave primaria
    @Column(name = "id_talla")                                  // Anotacion para definir el Id de la columna en la base de datos
    private Integer idTalla;                                    // Variable para manejar el Id de talla de la BD

    @NotBlank(message = "El tipo de Talla es Obligatrio")       // Anotacion para validar que el campo no sea nulo, y mostrar mensaje de error personalizado
    @Column(name = "tipo_talla")                                // Anotacion para definir el tipo de talla de la columna en la base de datos
    private String tipoTalla;                                   // variable para manejar los datos del tipo de talla

    @OneToMany(mappedBy = "talla",                              // Anotacion que indica que la relación está controlada desde la otra clase (RopaTalla), y no desde esta
                fetch = FetchType.LAZY, 
                cascade = CascadeType.ALL, 
                orphanRemoval = true)                                                        
    private Set<EntidadRopaTalla> ropasAsignadas = new HashSet<>();// lista inicializada vacía para almacenar los objetos EntidadRopaTalla relacionados o asociados a talla.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntidadTalla)) return false;
        EntidadTalla that = (EntidadTalla) o;
        return Objects.equals(idTalla, that.idTalla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTalla);
    }
}
