package com.rene.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rene.mercado.model.Talla;

@Repository
public interface TallaRepository 
    extends JpaRepository<Talla, Integer>{

}
