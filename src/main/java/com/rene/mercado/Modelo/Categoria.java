package com.rene.mercado.Modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "categoria", schema = "rene")

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_caduce")
    private Caduce caduce;
    
    @OneToMany(mappedBy = "categoria")
    private List<Productos> productos;
}
