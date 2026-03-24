package com.rene.mercado.Entidad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "ropa", schema = "rene")                      // Anotacion para definir la tabla y el esquema al que pertenece

public class EntidadRopa {

    @Id                                                     // Anotacion para identificar la llave primaria de la entidad ropa
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Anotacion para definir el dato auto-incremental a la llave primaria
    @Column(name = "id_ropa")                               // Anotacion para definir el Id de la columna en la base de datos
    private Integer idRopa;                                 // Variable para manejar el Id de ropa de la BD

    @ManyToOne(fetch = FetchType.LAZY)                      // Anotacion que apuntamos a la relacion de muchos a uno entre ropa y Producto, y carga los datos de la entidad principal (LAZY)
    @JoinColumn(name = "id_producto")                       // Anotacion para referirnos a la llave foranea que se relaciona con la tabla ropa
    private EntidadProductos producto;                      // Variable para almacenar los datos de producto asociado a ropa

    @OneToMany(mappedBy = "ropa",                           // Anotacion que indica que la relación está controlada desde la otra clase (RopaTalla), y no desde esta
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL, 
                orphanRemoval = true)                       // relacion que apunta a la entidad intermedia 'RopaTalla'
    private List<EntidadRopaTalla> tallasAsignadas = new ArrayList<>(); // lista inicializada vacía para almacenar los objetos EntidadRopaTalla relacionados o asociados a ropa.

    @ManyToMany(fetch = FetchType.LAZY)                     // Anotacion para hacer referencia la relacion de muchos a uno entre ropa y origen y cargar los datos de la entidad principal (LAZY)
    @JoinTable(name = "ropa_origen", 
                schema = "rene", 
                joinColumns = @JoinColumn(name = "id_ropa"),            // Parametro para hacer referencia a la entidad ropa con la llave forane id_ropa.
                inverseJoinColumns = @JoinColumn(name = "id_origen"))   // Parametro para hacer referencia a la columna de la llave foranea de la tabla intermedia que apunta al objeto del otro lado de la relación.
    private Set<EntidadOrigen> origenes = new HashSet<>();              // lista inicializada vacía para almacenar los objetos EntidadOrigen relacionados o asociados a ropa.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntidadRopa)) return false;
        EntidadRopa that = (EntidadRopa) o;
        return Objects.equals(idRopa, that.idRopa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRopa);
    }
}
