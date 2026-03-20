package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadComida;
import com.rene.mercado.Repositorio.RepositorioComida;
import com.rene.mercado.Servicio.ServicioComida;

@Service

public class ImplementacionServicioComida implements ServicioComida {

    @Autowired
    private RepositorioComida comidaRepositorio;

    @Override
    public EntidadComida guardarComidas(@NonNull EntidadComida Comidas) {
        return comidaRepositorio.save(Comidas);
    }

    @Override
    public EntidadComida buscarComidasPorId(@NonNull Integer id) {
        return comidaRepositorio.buscarComidasPorId(id);
    }

    @Override
    public List<EntidadComida> obtenerComidas() {
        return comidaRepositorio.listarComida();
    }

    @Override
    public EntidadComida editarComidas(@NonNull EntidadComida Comidas) {
        return comidaRepositorio.saveAndFlush(Comidas);
    }

    @Override
    public void eliminarComidasPorId(@NonNull Integer id) {
        comidaRepositorio.deleteById(id);
    }

}
