package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rene.mercado.Modelo.Origen;

public interface RepositorioOrigen
                extends JpaRepository<Origen, Integer> {
        @Query("SELECT o FROM Origen o ORDER BY o.nombreOrigen")
        List<Origen> listarOrigen();
}
