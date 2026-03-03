package com.ndduroc.rocmovies.Services.Interfaces;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.ndduroc.rocmovies.entity.Customer;


public interface CustomerRepository extends R2dbcRepository<Customer, Integer>{}