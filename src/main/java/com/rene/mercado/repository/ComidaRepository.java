package com.rene.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rene.mercado.model.Comida;

public interface ComidaRepository 
    extends JpaRepository<Comida, Integer>{

}
