package com.lax.Stugbokning.controller;

import com.lax.Stugbokning.entitys.Cabins;
import com.lax.Stugbokning.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://127.0.0.1:8080","http://localhost:8080","http://localhost:8082","http://localhost:5002"}, allowCredentials = "true")
public class CabinController {

    @Autowired
    CabinService cabinService;

    // Listar alla stugor
    @GetMapping("/cabins")
    public List<Cabins> cabins(){
        return cabinService.cabins();
    }

    // Listar en specifik stuga
    @GetMapping("/cabins/{id}")
    public Cabins getCabins(@PathVariable long id){
        return cabinService.findCabinById(id);
    }
    // Listar stugor efter storlek på stugan
    @GetMapping("/cabinstype/{type}")
    public List<Cabins> getCabinsByType(@PathVariable String type){
        return cabinService.findCabinsByType(type);
    }

    // Lägger till en ny stuga
    @PostMapping("/addcabins")
    public Cabins addCabin(@RequestBody Cabins cabin){
        return cabinService.addCabin(cabin);
    }

    // Tar bort en stuga från databasen. (Som är sagt tidigare så ska man aldrig ta bort något från en databas)
    @DeleteMapping("/deletecabin")
    public String deleteCabin(@RequestBody Cabins cabin){
        return cabinService.deleteCabin(cabin);
    }

    // Uppdaterar information på befintlig stuga
    @PutMapping("/updatecabin")
    public Cabins updateCabin(@RequestBody Cabins cabin){
        return cabinService.updateCabin(cabin);
    }
}
