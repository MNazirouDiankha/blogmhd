package com.esp.gestionarticle.service;


import com.esp.gestionarticle.domain.Article;
import com.esp.gestionarticle.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    Article createArticle(ArticleDTO article);

    public List<Article> findByCategorie(String categorieName);


    Article findById(Long id);

    void deleteArticle(Long id);


    Article updateArticle(Long id, Article article);
}
