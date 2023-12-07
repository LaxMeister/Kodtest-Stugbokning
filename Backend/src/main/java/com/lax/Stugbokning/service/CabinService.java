package com.lax.Stugbokning.service;

import com.lax.Stugbokning.dao.CabinRepo;
import com.lax.Stugbokning.dao.OrderRepo;
import com.lax.Stugbokning.entitys.Cabins;
import com.lax.Stugbokning.entitys.Orders;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CabinService {
    @Autowired
    CabinRepo cabinRepo;

    @Autowired
    OrderRepo orderRepo;

    public List<Cabins> cabins() {
        return cabinRepo.findAll();
    }

    public Cabins findCabinById(long id) {
        Cabins cabin = cabinRepo.findById(id);
        return cabin;

    }
    public List<Cabins> findCabinsByType(String type) {
        List<Cabins> cabins = cabinRepo.findByType(type);
        return cabins ;
    }
    public Cabins addCabin(Cabins cabins) {
        cabinRepo.findAll().add(cabins);
        cabinRepo.save(cabins);
        return cabins;
    }

    public Cabins updateCabin(Cabins cabin) {
        Cabins updatedCabin = new Cabins();
        updatedCabin.setId(cabin.getId());
        updatedCabin.setPrice(cabin.getPrice());
        updatedCabin.setName(cabin.getName());
        updatedCabin.setDate(cabin.getDate());
        updatedCabin.setBooked(cabin.isBooked());
        updatedCabin.setDetails(cabin.getDetails());
        updatedCabin.setType(cabin.getType());
        cabinRepo.save(updatedCabin);
        return updatedCabin;
    }

    public String deleteCabin(Cabins cabin) {
        Cabins cabinInfo = cabinRepo.findById(cabin.getId());
        Cabins carDelete = cabinRepo.deleteById(cabin.getId());
        List<Cabins> newCabin = cabinRepo.findWhere(cabinInfo.getType(),false);
        if(cabinInfo.isBooked() == true){
            Orders order = orderRepo.findByCabinId(cabinInfo.getId());
            order.setCabin(newCabin.get(0).getName());
            order.setCabinId(newCabin.get(0).getId());
            newCabin.get(0).setBooked(true);
            orderRepo.save(order);
            cabinRepo.save(newCabin.get(0));
        }


        return cabinInfo.getName() + " " + " was deleted";
    }
}
