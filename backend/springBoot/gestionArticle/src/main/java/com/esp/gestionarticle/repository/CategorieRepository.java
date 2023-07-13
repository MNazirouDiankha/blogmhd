package com.esp.gestionarticle.repository;

import com.esp.gestionarticle.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Categorie findByName(String categorieName);
}
