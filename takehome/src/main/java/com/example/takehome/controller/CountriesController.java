package com.example.takehome.controller;


import com.example.takehome.service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CountriesController {


    @Autowired
    CountriesService countriesService;

    @RequestMapping(value = "/countries",
            method = RequestMethod.POST, consumes="application/json",
            produces = "application/json")
    @ResponseBody
    public String getCountries(@RequestBody  Map<String, String> input) throws Exception{
        String data = countriesService.getCountriesData(input.get("countries"));
        return data;
    }
}
