package com.ndduroc.rocmovies.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table("movies")
public class Movie {

    @Id
    private Integer idMovie;
    private String title;
    private int styleId;
    private Integer productionYear;
    private String image;

    @Transient
    private Style style;

    public Movie() {}

    public Movie(String title, int styleId, int productionYear, String image) {
        this.title = title;
        this.styleId = styleId;
        this.productionYear = productionYear;
        this.image = image;
    }

    public Movie(int idMovie, String title, int styleId, int productionYear, String image) {
        this(title, styleId, productionYear, image);
        this.idMovie = idMovie;
    }

    public Integer getIdMovie() { return idMovie; }
    public void setIdMovie(Integer idMovie) { this.idMovie = idMovie; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getStyleId() { return styleId; }
    public void setStyleId(int styleId) { this.styleId = styleId; }

    public Integer getProductionYear() { return productionYear; }
    public void setProductionYear(Integer productionYear) { this.productionYear = productionYear; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Style getStyle() { return style; }
    public void setStyle(Style style) { this.style = style; }
}