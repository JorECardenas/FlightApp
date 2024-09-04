package com.encora.flightapp.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class FlightOption {

    String depAirport;
    String arrAirport;

    Date detDate;
    Date arrDate;

    String airline;
    String opAirline;

    String time;

    ArrayList<FlightStop> stops;

    Float totalPrice;
    Float idvPrice;





}
