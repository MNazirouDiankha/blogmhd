package com.esp.gestionarticle.controller;

import com.esp.gestionarticle.domain.Article;
import com.esp.gestionarticle.dto.ArticleDTO;
import com.esp.gestionarticle.exception.ApiException;
import com.esp.gestionarticle.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {
    /**
     * - GET /api/v1/article
     * - POST /api/v1/article
     * - GET /api/v1/article/{id}
     * - PATCH /api/v1/article/{id}
     * - PUT /api/v1/article/{id}
     * - DELETE /api/v1/article/{id}
     * - GET /api/v1/article/search?categorie="sport"
     */

    private final ArticleService articleService;


    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody ArticleDTO article ) {
        Article articleResponse = articleService.createArticle(article);
        if(articleResponse == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "article not created");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(articleResponse);
    }

    // find all articles
    @GetMapping
    public ResponseEntity<List<Article>> findAllArticle() {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.findAll());
    }

    // find article by id
    @GetMapping("/{id}")
    public Article findOneArticleById(@PathVariable Long id) {
        return articleService.findById(id);
    }


    // find article by categorie name
    @GetMapping("/categorie/{categorieName}")
    public List<Article> findArticleByCategorie(@PathVariable String categorieName) {
        return articleService.findByCategorie(categorieName);
    }

    // delete article by id
    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

    // update article
    @PatchMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article article ) {
        return articleService.updateArticle(id, article);
    }
}


