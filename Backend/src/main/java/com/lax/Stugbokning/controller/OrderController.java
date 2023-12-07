package com.lax.Stugbokning.controller;

import com.lax.Stugbokning.entitys.Orders;
import com.lax.Stugbokning.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://127.0.0.1:8080","http://localhost:8080","http://localhost:8082","http://localhost:5002"}, allowCredentials = "true")
public class OrderController {

    @Autowired
    OrderService orderService;

    // Visar alla kunders nuvarande och tidigare ordrar.
    @GetMapping("/myorders")
    public List<Orders> myOrders() {
        return orderService.myOrders();
    }

    // Visar en specifik kunds alla tidigare och nuvarande ordrar.
    @GetMapping("/onecustomersorders/{customerId}")
    public List<Orders> oneCustomersOrders(@PathVariable long customerId){
        return orderService.oneCustomersOrders(customerId);
    }

    // I postman skriv bara 2st siffror och sedan datum (2023-12-062023-12-07) i plain text i bodyn.
    // Första siffran är kund ID och andra siffran är stugan ID. Exempel: 23
    @PostMapping("/ordercabin/{number}")
    public Orders orderCabin(@PathVariable String number, @RequestBody String date ) {
        return orderService.orderCabin(number, date);
    }

    // Sätter en bool på stugan som är uthyrd till false.
    @PutMapping("/updateorder")
    public Orders updateOrders(@RequestBody long id){
        return orderService.updateOrder(id);
    }

    @GetMapping("/orders/{id}")
    public Orders getOneOrder(@PathVariable long id){
        return orderService.findOrderById(id);
    }

}
