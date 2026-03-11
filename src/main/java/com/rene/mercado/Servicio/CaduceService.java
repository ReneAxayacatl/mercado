package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Repositorio.CaduceRepository;
import com.rene.mercado.Servicio.Implementacion.ICaduceService;

@Service

public class CaduceService implements ICaduceService {

    @Autowired
    private CaduceRepository caduceRepository;

    @Override
    public Caduce saveCaduce(Caduce Caduce) {
        return caduceRepository.save(Caduce);
    }

    @Override
    public Optional<Caduce> searchCaduceById(Integer id) {
        return caduceRepository.findById(id);
    }

    @Override
    public List<Caduce> obtainCaduce() {
        return caduceRepository.findAll();
    }

    @Override
    public Caduce editCaduce(Caduce Caduce) {
        return caduceRepository.saveAndFlush(Caduce);
    }

    @Override
    public void deleteCaduce(Integer id) {
        caduceRepository.deleteById(id);
    }

}
