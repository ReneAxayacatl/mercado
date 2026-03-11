package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Comida;
import com.rene.mercado.Repositorio.RepositorioComida;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioComida;

@Service

public class ServicioComida implements ImplementacionServicioComida {

    @Autowired
    private RepositorioComida comidaRepositorio;

    @Override
    public Comida saveComidas(Comida Comidas) {
        return comidaRepositorio.save(Comidas);
    }

    @Override
    public Optional<Comida> searchComidasById(Integer id) {
        return comidaRepositorio.findById(id);
    }

    @Override
    public List<Comida> obtainComidas() {
        return comidaRepositorio.findAll();
    }

    @Override
    public Comida editComidas(Comida Comidas) {
        return comidaRepositorio.saveAndFlush(Comidas);
    }

    @Override
    public void deleteComidas(Integer id) {
        comidaRepositorio.deleteById(id);
    }

}
