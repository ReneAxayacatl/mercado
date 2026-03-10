package com.rene.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rene.mercado.model.Categoria;

public interface CategoriaRepository 
    extends JpaRepository<Categoria, Integer>{

}
