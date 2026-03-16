package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Modelo.Origen;

public interface RepositorioCaduce
                extends JpaRepository<Caduce, Integer> {
        @Query("SELECT c FROM Caduce c ORDER BY c.idCaduce")
        List<Caduce> listarCaduce();
}
