package com.ndduroc.rocmovies.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ndduroc.rocmovies.Services.Interfaces.ICustomerService;
import com.ndduroc.rocmovies.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService service;

    public CustomerController(){}

    @GetMapping("")
    public Flux<Customer> getMoviesByStyle(){  
        return service.getCustomers();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getOneMovie(@PathVariable int id) {
        return service.getCustomerById(id)
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "id incorrect")));
    }


}
