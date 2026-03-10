package com.rene.mercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.model.Comida;
import com.rene.mercado.repository.ComidaRepository;

@Service

public class ComidaService implements IComidaService {

    @Autowired
    private ComidaRepository comidaRepository;

    @Override
    public Comida saveComidas(Comida Comidas) {
        return comidaRepository.save(Comidas);
    }

    @Override
    public Optional<Comida> searchComidasById(Integer id) {
        return comidaRepository.findById(id);
    }

    @Override
    public List<Comida> obtainComidas() {
        return comidaRepository.findAll();
    }

    @Override
    public Comida editComidas(Comida Comidas) {
        return comidaRepository.saveAndFlush(Comidas);
    }

    @Override
    public void deleteComidas(Integer id) {
        comidaRepository.deleteById(id);
    }

}
