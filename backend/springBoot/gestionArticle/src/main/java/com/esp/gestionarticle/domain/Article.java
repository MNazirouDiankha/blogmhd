package com.esp.gestionarticle.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "content")
    private String content;

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public Article(String titre, String content, String image, Categorie categorie) {
        this.titre = titre;
        this.content = content;
        this.image = image;
        this.categorie = categorie;
    }

    public String getCategorieName() {
        return (categorie != null) ? categorie.getName() : null;
    }
}
