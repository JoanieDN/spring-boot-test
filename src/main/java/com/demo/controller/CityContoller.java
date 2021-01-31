package com.demo.controller;

import com.demo.model.Country;
import com.demo.repository.CityRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.model.City;

@RestController
@RequestMapping("city")
@CrossOrigin("*")
public class CityContoller implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CityRepository cityRepo;

    @GetMapping
    public List<City> getCities(){
        return cityRepo.findAll();
    }

    @PostMapping("/new-city")
    public City addCity(@RequestBody City city){
        // create new city in DB
        return cityRepo.save(city);
    }

    @PostMapping("/find-city/{id}")
    public Optional<City>  findCity(@PathVariable Long id){
        // find city by id
         Optional<City> city =  cityRepo.findById(id);
         return city;
    }

    @PutMapping("/{id}")
    public int updateCity(@PathVariable Long id,@RequestBody City city){
        //update city
        return cityRepo.updateCity(id, city.getCountry().getId(), city.getName());
    }

    @DeleteMapping("/{id}")
    public void updateCity(@PathVariable Long id){
        // delete city by id
        cityRepo.deleteById(id);
    }

}
