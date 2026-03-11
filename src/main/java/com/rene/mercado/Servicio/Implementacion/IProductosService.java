package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Productos;

public interface IProductosService {

    Productos saveProductos(Productos Productos);

    Optional<Productos> searchProductosById(Integer idInteger);

    List<Productos> obtainProductos();

    Productos editProductos(Productos Producto);

    void deleteProductos(Integer idInteger);
}
