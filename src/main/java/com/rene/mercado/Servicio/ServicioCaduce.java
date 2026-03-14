package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.lang.*;
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
    public Caduce guardarCaduce(Caduce Caduce) {
        return caduceRepositorio.save(Caduce);
    }

    @Override
    public Optional<Caduce> buscarCaducePorId(@NonNull Integer id) {
        return caduceRepositorio.findById(id);
        
    }

    @Override
    public List<Caduce> obtenerCaduce() {
        return caduceRepositorio.findAll();
    }

    @Override
    public Caduce editarCaduce(Caduce Caduce) {
        return caduceRepositorio.saveAndFlush(Caduce);
    }

    @Override
    public void eliminarCaducePorId(Integer id) {
        caduceRepositorio.deleteById(id);
    }

}
