package com.rene.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rene.mercado.model.Productos;

public interface ProductosRepository 
    extends JpaRepository<Productos, Integer>{

}
