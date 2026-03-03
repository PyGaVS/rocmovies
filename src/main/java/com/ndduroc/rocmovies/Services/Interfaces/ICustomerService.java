package com.ndduroc.rocmovies.Services.Interfaces;

import com.ndduroc.rocmovies.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {

    Flux<Customer> getCustomers();

    Mono<Customer> getCustomerById(int id);
}
