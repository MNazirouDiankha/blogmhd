package com.esp.gestionarticle.controller;

import com.esp.gestionarticle.domain.Article;
import com.esp.gestionarticle.domain.Categorie;
import com.esp.gestionarticle.exception.ApiException;
import com.esp.gestionarticle.service.CategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/categorie")
public class CategorieController {

    private final CategorieService categorieService;


    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        Categorie categorieReponse = categorieService.createCategorie(categorie);
        if(categorieReponse == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "categorie not created");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(categorieReponse);
    }

    // find all categories
    @GetMapping
    public ResponseEntity<List<Categorie>> findAllArticle() {
        return ResponseEntity.status(HttpStatus.OK).body(categorieService.findAll());
    }

    // find categorie by id
    @GetMapping("/{id}")
    public Categorie findOneCategorieById(@PathVariable Long id) {
        return categorieService.findById(id);
    }


    // find categorie by  name
    @GetMapping("/categorieName")
    public Categorie findByCategorieByName(@RequestParam(name="categorieName") String categorieName) {
        return  categorieService.findByName(categorieName);
    }

    // delete categorie by id
    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
    }


}
