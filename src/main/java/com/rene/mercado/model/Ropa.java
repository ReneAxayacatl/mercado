package com.rene.mercado.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "ropa", schema = "rene")

public class Ropa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ropa")
    private Integer idRopa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Productos producto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ropa_talla",
            schema = "rene",
            joinColumns = @JoinColumn(name = "id_ropa"),
            inverseJoinColumns = @JoinColumn(name = "id_talla")
) private List < Talla > tallas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="ropa_origen",
            schema="rene",
            joinColumns=@JoinColumn(name="id_ropa"),
            inverseJoinColumns=@JoinColumn(name="id_origen")
    )
    private List<Origen> origenes;

    /* @ManyToMany
    @JoinColumn(name = "id_talla")
    private Talla talla;

    @ManyToMany
    @JoinColumn(name = "id_origen")
    private Origen origen; */
}
