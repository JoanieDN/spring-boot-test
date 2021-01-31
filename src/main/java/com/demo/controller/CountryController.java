package com.demo.controller;

import com.demo.model.City;
import com.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.demo.model.Country;


@RestController
@RequestMapping(value = "country")
@CrossOrigin("*")
public class CountryController {

    @Autowired
    private CountryRepository countryRepo;

    @GetMapping
    public List<Country> getCountries(){
        // get all countries in an array
        return countryRepo.findAll();
    }

    @PostMapping("/new-country")
    public Country addCountry(@RequestBody Country country){

        //save a new country
        return countryRepo.save(country);
    }


}
