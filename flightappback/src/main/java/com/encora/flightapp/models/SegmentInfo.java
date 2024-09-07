package com.encora.flightapp.models;

import io.swagger.client.model.Itineraries;
import io.swagger.client.model.Segment;
import io.swagger.client.model.TravelerPricing;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SegmentInfo {

    LocalDateTime depDate;
    LocalDateTime arrDate;

    String depAirport;
    String arrAirport;

    //String airline;

    //String flightNumber;


    //String carrier;

    //String aircraftType;

    List<TravelerFare> fares;

    List<FlightStop> stops;

    String time;



    public SegmentInfo(Itineraries segment, List<TravelerPricing> pricings){

        time = segment.getDuration();

        depDate = segment.getSegments().getFirst().getDeparture().getAt();

        arrDate = segment.getSegments().getLast().getArrival().getAt();


        depAirport = segment.getSegments().getFirst().getDeparture().getIataCode();

        arrAirport = segment.getSegments().getLast().getArrival().getIataCode();

        stops = new ArrayList<>();

        for(int i = 1; i <= segment.getSegments().size() - 1; i++){

            String airport = segment.getSegments().get(i).getDeparture().getIataCode();

            LocalDateTime start = segment.getSegments().get(i - 1).getArrival().getAt();
            LocalDateTime end = segment.getSegments().get(i).getDeparture().getAt();

            Duration diff = Duration.between(start, end);

            stops.add(new FlightStop(airport, diff.toString()));

        }

        fares = new ArrayList<>();







    }
}

