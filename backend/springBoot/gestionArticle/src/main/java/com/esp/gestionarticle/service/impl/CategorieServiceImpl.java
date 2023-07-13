package com.esp.gestionarticle.service.impl;

import com.esp.gestionarticle.domain.Categorie;
import com.esp.gestionarticle.repository.CategorieRepository;
import com.esp.gestionarticle.service.CategorieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie findById(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @Override
    public Categorie findByName(String categorieName) {
        return categorieRepository.findByName(categorieName);
    }

    @Override
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}
