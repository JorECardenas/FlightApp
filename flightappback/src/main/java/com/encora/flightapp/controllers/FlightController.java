package com.encora.flightapp.controllers;

import com.encora.flightapp.models.FlightDetails;
import com.encora.flightapp.services.FlightService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestClientBuilderConfigurer;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        try{
            String formattedDepDate = formatter.format(parser.parse(DepDate));

            String formattedArrDate = null;

            if (!ArrDate.isBlank() && !ArrDate.isEmpty()) {
                formattedArrDate = formatter.format(parser.parse(ArrDate));;
            }

            return flightService.getFromAPI(DepAirport,
                    ArrAirport,
                    formattedDepDate,
                    formattedArrDate,
                    NumAdults,
                    Currency,
                    NonStop);
        }catch (ParseException e){
            throw new RuntimeException(e.toString());
        }




    }

}
