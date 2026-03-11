package com.rene.mercado.Modelo;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "talla", schema = "rene")

public class Talla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talla")
    private Integer idTalla;

    // @NotBlank(message = "El tipo de Talla es Obligatrio")
    @Column(name = "tipo_talla")
    private String tipoTalla;
    
    @OneToMany(mappedBy = "talla", cascade = CascadeType.ALL, orphanRemoval = true) // relacion que apunta a la entidad intermedia 'RopaTalla' (Entidad Hija)
    private List<RopaTalla> ropasAsignadas;

}
