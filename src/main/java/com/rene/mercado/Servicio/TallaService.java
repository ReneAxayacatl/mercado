package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Talla;
import com.rene.mercado.Repositorio.TallaRepository;
import com.rene.mercado.Servicio.Implementacion.ITallaService;

@Service

public class TallaService implements ITallaService {

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
