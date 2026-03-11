package com.rene.mercado.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rene.mercado.Modelo.Talla;

@Repository
public interface RepositorioTalla 
    extends JpaRepository<Talla, Integer>{

}
