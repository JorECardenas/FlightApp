package com.encora.flightapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FlightController {

    @GetMapping("/getExample")
    public String getExampleData(){



        return "test";

    }

}
