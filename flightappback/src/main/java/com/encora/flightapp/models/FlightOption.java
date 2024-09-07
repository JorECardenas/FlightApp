package com.encora.flightapp.models;

import io.swagger.client.model.FlightOffer;
import io.swagger.client.model.Itineraries;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
public class FlightOption {

    String depAirport;
    String arrAirport;

    LocalDate depDate;
    LocalDate arrDate;

    String airline;
    String opAirline;

    String time;

    ArrayList<FlightStop> stops;

    Float totalPrice;
    Float idvPrice;





}
