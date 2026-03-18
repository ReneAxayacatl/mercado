package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;
import org.springframework.lang.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Repositorio.RepositorioCaduce;
import com.rene.mercado.Servicio.ServicioCaduce;

@Service

public class ImplementacionServicioCaduce implements ServicioCaduce {

    @Autowired
    private RepositorioCaduce caduceRepositorio;

    @Override
    public Caduce guardarCaduce(@NonNull Caduce Caduce) {
        return caduceRepositorio.save(Caduce);
    }

    // @Override
    // public Optional<Caduce> buscarCaducePorId(@NonNull Integer id) {
    // return caduceRepositorio.findById(id);

    // }
    // @Override
    // public Caduce buscarCaducePorId(@NonNull Integer id) {
    // return caduceRepositorio.findById(id).orElse(null);

    // }
    @Override
    public Caduce buscarCaducePorId(@NonNull Integer id) {
        return caduceRepositorio.buscarCaducePorId(id);
    }

    @Override
    public List<Caduce> obtenerCaduce() {
        return caduceRepositorio.listarCaduce();
    }

    @Override
    public Caduce editarCaduce(@NonNull Caduce Caduce) {
        return caduceRepositorio.saveAndFlush(Caduce);
    }

    @Override
    public void eliminarCaducePorId(@NonNull Integer id) {
        caduceRepositorio.deleteById(id);
    }

}
