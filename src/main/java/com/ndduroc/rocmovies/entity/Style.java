package com.ndduroc.rocmovies.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("styles")
public class Style {

    @Id
    private Integer id;
    private String name;

    public Style() {}

    public Style(String name) {
        this.name = name;
    }

    public Style(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}