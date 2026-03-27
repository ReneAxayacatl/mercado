package com.rene.mercado.DTO;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

public class DTOProducto {

    private Integer idProducto;
    private Integer idCategoria;
    private BigDecimal precioUnit;
    private String nombreCategoria;
    private String nombreCaduce;

}