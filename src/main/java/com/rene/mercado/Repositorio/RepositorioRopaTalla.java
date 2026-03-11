package com.rene.mercado.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rene.mercado.Modelo.RopaTalla;
import com.rene.mercado.Modelo.RopaTallaPK;

@Repository

public interface RepositorioRopaTalla 
    extends JpaRepository<RopaTalla, RopaTallaPK> {

}
