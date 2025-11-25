package com.ndduroc.rocmovies.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ndduroc.rocmovies.Services.Interfaces.ICustomerService;
import com.ndduroc.rocmovies.entity.Customer;
import com.ndduroc.rocmovies.entity.Movie;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService service;

    public CustomerController(){}

    @GetMapping("")
    public List<Customer> getMoviesByStyle(){  
        return service.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getOneMovie(@PathVariable int id) {
        Optional<Customer> res = service.getCustomerById(id);
        if(res.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id incorrect");
        } else {
            return res.get();
        }

        
    }
}
