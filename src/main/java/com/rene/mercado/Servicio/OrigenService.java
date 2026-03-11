package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Origen;
import com.rene.mercado.Repositorio.OrigenRepository;
import com.rene.mercado.Servicio.Implementacion.IOrigenService;

@Service

public class OrigenService implements IOrigenService {
    @Autowired
    private OrigenRepository origenRepository;

    public Origen saveOrigen(Origen Origen) {
        return origenRepository.save(Origen);
    }

    @Override
    public Optional<Origen> searchOrigenById(Integer id) {
        return origenRepository.findById(id);
    }

    @Override
    public List<Origen> obtainOrigen() {
        return origenRepository.findAll();
    }

    @Override
    public Origen editOrigen(Origen origen) {
        return origenRepository.saveAndFlush(origen);
    }

    @Override
    public void deleteOrigen(Integer id) {
        origenRepository.deleteById(id);
    }
}
