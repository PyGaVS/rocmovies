package com.ndduroc.rocmovies.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="borrows")
public class Borrow {
    public Borrow(int id, Date date, Customer customer) {
        this(date, customer);
        this.id = id;
    }

    public Borrow(Date date, Customer customer) {
        this.date = date;
    }

    public Borrow() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    public Date date;

    @Column
    public String name;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable=false)
    public Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable=false)
    public Movie movie;
}
