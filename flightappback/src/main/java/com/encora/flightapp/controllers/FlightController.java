package com.encora.flightapp.controllers;

import com.encora.flightapp.services.FlightService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestClientBuilderConfigurer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;


@RestController
public class FlightController {


    @Autowired
    private final FlightService flightService;

    public FlightController(FlightService _flightService) {
        flightService = _flightService;
    }




    @GetMapping("/getFlights")
    public String getFlightData(@RequestParam String DepAirport,
                                @RequestParam String ArrAirport,
                                @RequestParam String DepDate,
                                @RequestParam String ArrDate,
                                @RequestParam int NumAdults,
                                @RequestParam String Currency,
                                @RequestParam boolean NonStop) {




        return flightService.getFromAPI();


    }

}
