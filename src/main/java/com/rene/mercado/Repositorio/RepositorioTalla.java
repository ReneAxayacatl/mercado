package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rene.mercado.Modelo.Talla;

@Repository
public interface RepositorioTalla
                extends JpaRepository<Talla, Integer> {
        @Query("SELECT t FROM Talla t ORDER BY t.tipoTalla")
        List<Talla> listarTallas();
}
