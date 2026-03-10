package com.rene.mercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.model.Talla;
import com.rene.mercado.repository.TallaRepository;

@Service

public class TallaService implements ITallaService{

    @Autowired
    private TallaRepository tallaRepository;

    @Override
    public Talla saveTallas(Talla tallas) {
        return tallaRepository.save(tallas);
    }

    @Override
    public Optional<Talla> searchTallaById(Integer id) {
        return tallaRepository.findById(id);
    }

    @Override
    public List<Talla> obtainTallas() {
        return tallaRepository.findAll();
    }

    @Override
    public Talla editTallas(Talla tallas) {
        return tallaRepository.saveAndFlush(tallas);
    }

    @Override
    public void deleteTallas(Integer id) {
        tallaRepository.deleteById(id);
    }

}
