package com.lax.Stugbokning.dao;

import com.lax.Stugbokning.entitys.Cabins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CabinRepo extends JpaRepository<Cabins, Long> {
    Cabins findById(long id);
    Cabins deleteById(long id);
    Cabins findByName(String name);
    List<Cabins> findByType(String type);
    Cabins findByPrice(int price);

    @Query("select c from Cabins c where c.type= :type AND c.booked= :isbooked")
    List<Cabins> findWhere(String type, Boolean isbooked);
}
