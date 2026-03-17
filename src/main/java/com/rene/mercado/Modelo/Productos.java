package com.rene.mercado.Modelo;

import java.math.BigDecimal;

import jakarta.persistence.*;
// import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@Table(name = "productos", schema = "rene")

public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @NotNull(message = "El Precio Unitario es Obligatrio")
    @Column(name = "precio_unit")
    private BigDecimal precioUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria = new Categoria();
}
