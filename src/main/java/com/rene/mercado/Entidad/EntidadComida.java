package com.rene.mercado.Entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "comida", schema = "rene")

public class EntidadComida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comida")
    private Integer idComida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private EntidadProductos producto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="comida_origen",
            schema="rene",
            joinColumns=@JoinColumn(name="id_comida"),
            inverseJoinColumns=@JoinColumn(name="id_origen")
    )
    private List<EntidadOrigen> origenes;
}
