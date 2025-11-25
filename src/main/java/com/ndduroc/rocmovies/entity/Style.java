package com.ndduroc.rocmovies.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="styles")
public class Style {
    public Style(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Style(String name) {
        this.name = name;
    }

    public Style() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "style", cascade= CascadeType.ALL)
    private List<Movie> movies;

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }
    
}
