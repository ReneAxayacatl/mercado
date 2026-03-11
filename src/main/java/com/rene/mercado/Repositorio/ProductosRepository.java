package com.rene.mercado.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rene.mercado.Modelo.Productos;

public interface ProductosRepository 
    extends JpaRepository<Productos, Integer>{

}
