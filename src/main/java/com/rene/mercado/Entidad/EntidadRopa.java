package com.rene.mercado.Entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "ropa", schema = "rene")

public class EntidadRopa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ropa")
    private Integer idRopa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private EntidadProductos producto;

    @OneToMany(mappedBy = "ropa", 
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL, 
                orphanRemoval = true)       // relacion que apunta a la entidad intermedia 'RopaTalla'
    private List<EntidadRopaTalla> tallasAsignadas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ropa_origen", 
                schema = "rene", 
                joinColumns = @JoinColumn(name = "id_ropa"), 
                inverseJoinColumns = @JoinColumn(name = "id_origen"))
    private List<EntidadOrigen> origenes;
}
