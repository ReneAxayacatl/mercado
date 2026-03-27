package com.rene.mercado.DTO;

import java.util.Set;
import lombok.Data;

@Data

public class DTOComida {

    private Integer idComida;
    private Integer idProducto;
    private String nombreCategoria;
    private Set<String> origenes;   // nombres de origen
}
