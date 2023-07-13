package com.esp.gestionarticle.service;

import com.esp.gestionarticle.domain.Article;
import com.esp.gestionarticle.domain.Categorie;

import java.util.List;

public interface CategorieService {
    List<Categorie> findAll();

    Categorie createCategorie(Categorie categorie);

    Categorie findById(Long id);

    Categorie findByName(String categorieName);

    void deleteCategorie(Long id);

}
