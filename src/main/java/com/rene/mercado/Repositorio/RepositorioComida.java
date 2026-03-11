package com.rene.mercado.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rene.mercado.Modelo.Comida;

public interface RepositorioComida 
    extends JpaRepository<Comida, Integer>{

}
