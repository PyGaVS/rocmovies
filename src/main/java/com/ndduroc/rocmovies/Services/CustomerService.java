package com.ndduroc.rocmovies.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ndduroc.rocmovies.Services.Interfaces.CustomerRepository;
import com.ndduroc.rocmovies.Services.Interfaces.ICustomerService;
import com.ndduroc.rocmovies.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Primary
public class CustomerService implements ICustomerService {

    @Autowired 
    private CustomerRepository repo;

    @Override
    public Flux<Customer> getCustomers(){
        return repo.findAll();
    }

    @Override
    public Mono<Customer> getCustomerById(int id){
        return repo.findById(id);
    }
}
