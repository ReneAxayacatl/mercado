package com.rene.mercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.model.Categoria;
import com.rene.mercado.repository.CategoriaRepository;

@Service

public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria saveCategorias(Categoria Categorias) {
        return categoriaRepository.save(Categorias);
    }

    @Override
    public Optional<Categoria> searchCategoriasById(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> obtainCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria editCategorias(Categoria Categorias) {
        return categoriaRepository.saveAndFlush(Categorias);
    }

    @Override
    public void deleteCategorias(Integer id) {
        categoriaRepository.deleteById(id);
    }

}
