package com.ndduroc.rocmovies.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ndduroc.rocmovies.Services.Interfaces.ICustomerService;
import com.ndduroc.rocmovies.entity.Customer;
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
}
