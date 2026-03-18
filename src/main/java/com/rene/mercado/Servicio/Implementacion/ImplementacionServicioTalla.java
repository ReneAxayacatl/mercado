package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Talla;
import com.rene.mercado.Repositorio.RepositorioTalla;
import com.rene.mercado.Servicio.ServicioTalla;

@Service

public class ImplementacionServicioTalla implements ServicioTalla {

    @Autowired
    private RepositorioTalla tallaRepositorio;

    @Override
    public Talla guardarTallas(@NonNull Talla tallas) {
        return tallaRepositorio.save(tallas);
    }

    @Override
    public Optional<Talla> buscarTallaPorId(@NonNull Integer id) {
        return tallaRepositorio.findById(id);
    }

    @Override
    public List<Talla> obtenerTallas() {
        return tallaRepositorio.listarTallas();
    }

    @Override
    public Talla editarTallas(@NonNull Talla tallas) {
        return tallaRepositorio.saveAndFlush(tallas);
    }

    @Override
    public void eliminarTallasPorId(@NonNull Integer id) {
        tallaRepositorio.deleteById(id);
    }

}
