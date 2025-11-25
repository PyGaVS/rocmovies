package com.ndduroc.rocmovies.Services.Interfaces;

import java.util.List;

import com.ndduroc.rocmovies.entity.Customer;

public interface ICustomerService {
    List<Customer> getCustomers();
}
