package com.ndduroc.rocmovies.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="styles")
public class Style {
    public Style(int idStyle, String name) {
        this.idStyle = idStyle;
        this.name = name;
    }

    public Style(String name) {
        this.name = name;
    }

    public Style() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStyle;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }
    
}
