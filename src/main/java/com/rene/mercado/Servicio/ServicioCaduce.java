package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Repositorio.RepositorioCaduce;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioCaduce;

@Service

public class ServicioCaduce implements ImplementacionServicioCaduce {

    @Autowired
    private RepositorioCaduce caduceRepositorio;

    @Override
    public Caduce saveCaduce(Caduce Caduce) {
        return caduceRepositorio.save(Caduce);
    }

    @Override
    public Optional<Caduce> searchCaduceById(Integer id) {
        return caduceRepositorio.findById(id);
    }

    @Override
    public List<Caduce> obtainCaduce() {
        return caduceRepositorio.findAll();
    }

    @Override
    public Caduce editCaduce(Caduce Caduce) {
        return caduceRepositorio.saveAndFlush(Caduce);
    }

    @Override
    public void deleteCaduce(Integer id) {
        caduceRepositorio.deleteById(id);
    }

}
