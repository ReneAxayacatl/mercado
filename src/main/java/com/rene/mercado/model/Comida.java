package com.rene.mercado.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "comida", schema = "rene")

public class Comida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comida")
    private Integer idComida;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Productos producto;

    @ManyToMany
    @JoinTable(
            name="comida_origen",
            schema="rene",
            joinColumns=@JoinColumn(name="id_comida"),
            inverseJoinColumns=@JoinColumn(name="id_origen")
    )
    private List<Origen> origenes;

    /* @ManyToMany
    @JoinColumn(name = "id_origen")
    private Origen origen; */
}
