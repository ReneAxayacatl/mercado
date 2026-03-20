package com.rene.mercado.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rene.mercado.Entidad.EntidadRopaTalla;
import com.rene.mercado.Entidad.EntidadRopaTallaPK;

@Repository

public interface RepositorioRopaTalla 
    extends JpaRepository<EntidadRopaTalla, EntidadRopaTallaPK> {

}
