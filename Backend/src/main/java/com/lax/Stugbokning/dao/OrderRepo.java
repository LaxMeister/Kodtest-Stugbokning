package com.lax.Stugbokning.dao;

import com.lax.Stugbokning.entitys.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Orders, Long> {

    Orders findById(long id);
    Orders findByCabinId(long id);
    List<Orders> findAllByCustomerId(long customerId);


}
