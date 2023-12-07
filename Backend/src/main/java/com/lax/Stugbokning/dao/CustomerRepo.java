package com.lax.Stugbokning.dao;

import com.lax.Stugbokning.entitys.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findById(long id);
    Customer findByFirstname(String name);
    Customer findByUsername(String username);

}
