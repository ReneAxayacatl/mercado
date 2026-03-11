package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Ropa;
import com.rene.mercado.Repositorio.RopaRepository;
import com.rene.mercado.Servicio.Implementacion.IRopaService;

@Service

public class RopaService implements IRopaService {

    @Autowired
    private RopaRepository ropaRepository;

    @Override
    public Ropa saveRopas(Ropa ropas) {
        return ropaRepository.save(ropas);
    }

    @Override
    public Optional<Ropa> searchRopasById(Integer id) {
        return ropaRepository.findById(id);
    }

    @Override
    public List<Ropa> obtainRopas() {
        return ropaRepository.findAll();
    }

    @Override
    public Ropa editRopas(Ropa tallas) {
        return ropaRepository.saveAndFlush(tallas);
    }

    @Override
    public void deleteRopas(Integer id) {
        ropaRepository.deleteById(id);
    }

}
