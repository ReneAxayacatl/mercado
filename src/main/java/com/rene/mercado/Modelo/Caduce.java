package com.rene.mercado.Modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "caduce", schema = "rene")
public class Caduce {

    @Id
    @Column(name = "id_caduce")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCaduce;

    @Column(name = "caduce")
    private String caduce;

    @OneToMany(mappedBy = "caduce", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Categoria> categorias;
}
