package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Comida;
import com.rene.mercado.Repositorio.RepositorioComida;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioComida;

@Service

public class ServicioComida implements ImplementacionServicioComida {

    @Autowired
    private RepositorioComida comidaRepositorio;

    @Override
    public Comida guardarComidas(@NonNull Comida Comidas) {
        return comidaRepositorio.save(Comidas);
    }

    @Override
    public Optional<Comida> buscarComidasPorId(@NonNull Integer id) {
        return comidaRepositorio.findById(id);
    }

    @Override
    public List<Comida> obtenerComidas() {
        return comidaRepositorio.listarComida();
    }

    @Override
    public Comida editarComidas(@NonNull Comida Comidas) {
        return comidaRepositorio.saveAndFlush(Comidas);
    }

    @Override
    public void eliminarComidasPorId(@NonNull Integer id) {
        comidaRepositorio.deleteById(id);
    }

}
