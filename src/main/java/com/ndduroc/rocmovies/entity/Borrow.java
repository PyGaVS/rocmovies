package com.ndduroc.rocmovies.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table("borrows")
public class Borrow {

    @Id
    private Integer id;
    private Date date;
    private String name;
    private int customerId;
    private int movieId;

    @Transient
    private Customer customer;

    @Transient
    private Movie movie;

    public Borrow() {}

    public Borrow(Date date, int customerId, int movieId) {
        this.date = date;
        this.customerId = customerId;
        this.movieId = movieId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getMovieId() { return movieId; }
    public void setMovieId(int movieId) { this.movieId = movieId; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
}