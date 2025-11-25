package com.ndduroc.rocmovies.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ndduroc.rocmovies.Services.Interfaces.CustomerRepository;
import com.ndduroc.rocmovies.Services.Interfaces.ICustomerService;
import com.ndduroc.rocmovies.entity.Customer;
import com.ndduroc.rocmovies.Services.Interfaces.CustomerRepository;

@Service
@Primary
public class CustomerService implements ICustomerService {

    @Autowired 
    private CustomerRepository repo;

    @Override
    public List<Customer> getCustomers(){
        return repo.findAll();
    }
}
