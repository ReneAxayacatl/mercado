package com.rene.mercado.Servicio.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadOrigen;
import com.rene.mercado.Repositorio.RepositorioOrigen;
import com.rene.mercado.Servicio.ServicioOrigen;

@Service

public class ImplementacionServicioOrigen implements ServicioOrigen {
    @Autowired
    private RepositorioOrigen origenRepositorio;

    public EntidadOrigen guardarOrigen(@NonNull EntidadOrigen Origen) {
        return origenRepositorio.save(Origen);
    }

    @Override
    public EntidadOrigen buscarOrigenPorId(@NonNull Integer id) {
        return origenRepositorio.buscarOrigenPorId(id);
    }

    @Override
    public List<EntidadOrigen> obtenerOrigen() {
        return origenRepositorio.listarOrigen();
    }

    @Override
    public EntidadOrigen editarOrigen(@NonNull EntidadOrigen origen) {
        return origenRepositorio.saveAndFlush(origen);
    }

    @Override
    public void eliminarOrigenPorId(@NonNull Integer id) {
        origenRepositorio.deleteById(id);
    }
}
