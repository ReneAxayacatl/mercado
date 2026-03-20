package com.rene.mercado.Servicio.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadTalla;
import com.rene.mercado.Repositorio.RepositorioTalla;
import com.rene.mercado.Servicio.ServicioTalla;

@Service

public class ImplementacionServicioTalla implements ServicioTalla {

    @Autowired
    private RepositorioTalla tallaRepositorio;

    @Override
    public EntidadTalla guardarTallas(@NonNull EntidadTalla tallas) {
        return tallaRepositorio.save(tallas);
    }

    @Override
    public EntidadTalla buscarTallaPorId(@NonNull Integer id) {
        return tallaRepositorio.buscarTallaPorId(id);
    }

    @Override
    public List<EntidadTalla> obtenerTallas() {
        return tallaRepositorio.listarTallas();
    }

    @Override
    public EntidadTalla editarTallas(@NonNull EntidadTalla tallas) {
        return tallaRepositorio.saveAndFlush(tallas);
    }

    @Override
    public void eliminarTallasPorId(@NonNull Integer id) {
        tallaRepositorio.deleteById(id);
    }

}
