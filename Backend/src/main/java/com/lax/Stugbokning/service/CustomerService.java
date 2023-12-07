package com.lax.Stugbokning.service;

import com.lax.Stugbokning.dao.CustomerRepo;
import com.lax.Stugbokning.entitys.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> customers() {
        return customerRepo.findAll();
    }

    public Customer findCustomer(long id) {
        Customer customer = customerRepo.findById(id);
        return customer;
    }

    public Customer findCurrentUser(String username) {
        Customer customer = customerRepo.findByUsername(username);
        return customer;
    }


}
