package com.esp.gestionarticle.dto;

import lombok.Data;

@Data
public class ArticleDTO {
    private String titre;
    private String content;
    private String image;
    private String categorieName;

    public ArticleDTO(String titre, String content, String image, String categorieName) {
        this.titre = titre;
        this.content = content;
        this.image = image;
        this.categorieName = categorieName;
    }
}
