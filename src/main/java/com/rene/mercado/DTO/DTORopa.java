package com.rene.mercado.DTO;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class DTORopa {
    private Integer idRopa;
    private Integer idProducto;
    private String nombreCategoria;
    private Set<String> origenes = new HashSet<>();
    private Set<String> tallas = new HashSet<>();
}