package com.ndduroc.rocmovies.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {

    public Movie(int idMovie, String title, MovieStyles style, int productionYear, String image) {
        this.idMovie = idMovie;
        this.title = title;
        this.style = style;
        this.productionYear = productionYear;
        this.image = image;
    }

    public Movie(String title, MovieStyles style, int productionYear, String image) {
        this.title = title;
        this.style = style;
        this.productionYear = productionYear;
        this.image = image;
    }

    public Movie() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovie;

    @Column
    private String title;

    @Column
    private MovieStyles style;
    
    @Column
    private Integer productionYear;

    @Column String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieStyles getStyle() {
        return style;
    }

    public void setStyle(MovieStyles style) {
        this.style = style;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    } 

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }
}
