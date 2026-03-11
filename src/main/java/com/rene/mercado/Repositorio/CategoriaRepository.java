package com.rene.mercado.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rene.mercado.Modelo.Categoria;

public interface CategoriaRepository 
    extends JpaRepository<Categoria, Integer>{

}
