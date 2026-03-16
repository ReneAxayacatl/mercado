package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rene.mercado.Modelo.Comida;

public interface RepositorioComida
                extends JpaRepository<Comida, Integer> {
        // @Query("SELECT c FROM Comida c JOIN c.producto p")
        @Query("SELECT c FROM Comida c JOIN c.producto p JOIN p.categoria cat")
        List<Comida> listarComida();
}
