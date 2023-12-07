package com.lax.Stugbokning.service;

import com.lax.Stugbokning.dao.CabinRepo;
import com.lax.Stugbokning.dao.CustomerRepo;
import com.lax.Stugbokning.dao.OrderRepo;
import com.lax.Stugbokning.entitys.Cabins;
import com.lax.Stugbokning.entitys.Customer;
import com.lax.Stugbokning.entitys.Orders;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

@Service
public class OrderService {


    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CabinRepo cabinRepo;

    public List<Orders> myOrders() {
        return orderRepo.findAll();
    }

    public List<Orders> oneCustomersOrders(long customerId) {
        return orderRepo.findAllByCustomerId(customerId);
    }

    public Orders orderCabin(String number, String date){
        String customerString = number.substring(0,1);
        String cabinString = number.substring(1,2);
        long customerId = Long.parseLong(customerString);
        long cabinId = Long.parseLong(cabinString);
        Customer customer = customerRepo.findById(customerId);
        Cabins cabin = cabinRepo.findById(cabinId);
        String rentDate = date.substring(0,10);
        String returnDate = date.substring(10,20);
        int rentInt = customer.getRentTimes();
        rentInt++;

        Orders newOrder = new Orders(customer.getFirstname(), customer.getLastname(), customer.getId(), cabin.getName() , cabin.getId(), rentDate,returnDate);
        cabin.setBooked(true);
        newOrder.setBooked(true);
        customer.setRentTimes(rentInt);
        customerRepo.save(customer);
        orderRepo.findAll().add(newOrder);
        orderRepo.save(newOrder);
        return newOrder;
    }

    public Orders updateOrder(long id){
        Orders order = orderRepo.findById(id);
        Cabins cabin = cabinRepo.findById(order.getCabinId());
        cabin.setBooked(false);
        order.setBooked(false);
        cabinRepo.save(cabin);
        orderRepo.save(order);
        return order;

    }

    public Orders findOrderById(long id) {
        Orders order = orderRepo.findById(id);
        return order;
    }

}
