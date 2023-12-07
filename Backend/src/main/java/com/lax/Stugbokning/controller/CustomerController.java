package com.lax.Stugbokning.controller;

import com.lax.Stugbokning.entitys.Customer;
import com.lax.Stugbokning.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://127.0.0.1:8080","http://localhost:8080","http://localhost:8082","http://localhost:5002"}, allowCredentials = "true")
public class CustomerController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    CustomerService customerService;

    // Listar alla kunder
    @GetMapping("/customers")
    public List<Customer> customers(){
        return customerService.customers();
    }

    // Listar specifik kund
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable long id){
        return customerService.findCustomer(id);
    }

    @GetMapping("/currentUser")
    public Customer getCurrentUser (){
        String userName = httpServletRequest.getUserPrincipal().getName();
        return customerService.findCurrentUser(userName);
    }
}