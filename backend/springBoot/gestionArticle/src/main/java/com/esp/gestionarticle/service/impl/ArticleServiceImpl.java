package com.esp.gestionarticle.service.impl;

import com.esp.gestionarticle.domain.Article;
import com.esp.gestionarticle.domain.Categorie;
import com.esp.gestionarticle.dto.ArticleDTO;
import com.esp.gestionarticle.repository.ArticleRepository;
import com.esp.gestionarticle.repository.CategorieRepository;
import com.esp.gestionarticle.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    private final CategorieRepository categorieRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategorieRepository categorieRepository) {
        this.articleRepository = articleRepository;
        this.categorieRepository = categorieRepository;
    }


    @Override
    public List<Article> findAll() {
        List<Article> articles  = articleRepository.findAll();


        return articles;

    }

    @Override
    public Article createArticle(ArticleDTO articleDTO) {
        Article article = new Article();
        article.setCategorie(categorieRepository.findByName(articleDTO.getCategorieName()));
        article.setTitre(articleDTO.getTitre());
        article.setContent(articleDTO.getContent());
        article.setImage(articleDTO.getImage());
        return articleRepository.save(article);
    }

    @Override
    public List<Article> findByCategorie(String categorieName) {
        Categorie categorie = categorieRepository.findByName(categorieName);
        return articleRepository.findByCategorie(categorie);
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article updateArticle(Long id, Article article) {
        Article existingArticle = articleRepository.findById(id).orElse(null);
        existingArticle.setTitre(article.getTitre());
        existingArticle.setContent(article.getContent());
        existingArticle.setImage(article.getImage());
        return articleRepository.save(existingArticle);
    }
}
