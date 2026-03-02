package com.ndduroc.rocmovies.Services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.ndduroc.rocmovies.entity.Customer;

public interface ICustomerService {

    List<Customer> getCustomers();

    Optional<Customer> getCustomerById(int id);
}
