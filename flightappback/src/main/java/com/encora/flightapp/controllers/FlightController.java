package com.encora.flightapp.controllers;

import com.encora.flightapp.models.FlightDetails;
import com.encora.flightapp.services.FlightService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestClientBuilderConfigurer;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import java.util.List;

@CrossOrigin("*")
@RestController
public class FlightController {


    @Autowired
    private final FlightService flightService;

    public FlightController(FlightService _flightService) {
        flightService = _flightService;
    }




    @GetMapping("/getFlights")
    public List<FlightDetails> getFlightData(@RequestParam String DepAirport,
                                             @RequestParam String ArrAirport,
                                             @RequestParam String DepDate,
                                             @RequestParam(value = "", required = false) String ArrDate,
                                             @RequestParam int NumAdults,
                                             @RequestParam String Currency,
                                             @RequestParam(value = "false", required = false) boolean NonStop) {

        return flightService.getFromAPI(DepAirport, ArrAirport, DepDate, ArrDate, NumAdults, Currency, NonStop);


    }

}
