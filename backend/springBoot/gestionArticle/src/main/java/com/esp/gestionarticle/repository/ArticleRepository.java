package com.esp.gestionarticle.repository;

import com.esp.gestionarticle.domain.Article;
import com.esp.gestionarticle.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByCategorie(Categorie categorie);
//    @Query("SELECT a FROM Article a JOIN a.categories c WHERE c.name = ?1")
//    List<Article> findByCategorie(String categorieName);


}
