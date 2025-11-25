package com.ndduroc.rocmovies.Services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.ndduroc.rocmovies.entity.Customer;
import com.ndduroc.rocmovies.entity.Movie;

public interface ICustomerService {

    List<Customer> getCustomers();

    Optional<Customer> getCustomerById(int id);
}
