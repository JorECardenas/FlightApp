package com.encora.flightapp.models;

import io.swagger.client.model.Dictionaries;
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
import java.util.Map;

@Data
public class SegmentInfo {

    LocalDateTime depDate;
    LocalDateTime arrDate;

    String depAirport;
    String arrAirport;

    String carrier;

    List<String> operated;

    List<FlightInfo> flights;

    List<FlightStop> stops;

    String time;



    public SegmentInfo(Itineraries segment, List<TravelerPricing> pricings, Map<String,AirportDictionaryItem> dict, Dictionaries dicts){


        time = segment.getDuration();

        flights = new ArrayList<>();

        for(Segment seg: segment.getSegments()){
            flights.add(new FlightInfo(seg, dict, dicts));
        }

        depDate = flights.getFirst().getDepDate();
        arrDate = flights.getLast().getArrDate();

        depAirport = flights.getFirst().getDepAirport();
        arrAirport = flights.getLast().getArrAirport();

        carrier = flights.getFirst().getCarrier();

        operated = flights.stream().map(FlightInfo::getCarrier).toList();



        stops = new ArrayList<>();

        for(int i = 1; i <= flights.size() - 1; i++){

            String airport = flights.get(i).getDepAirport();

            LocalDateTime start = flights.get(i - 1).getArrDate();
            LocalDateTime end = flights.get(i).getDepDate();

            Duration diff = Duration.between(start, end);

            stops.add(new FlightStop(airport, diff.toString()));

        }








    }
}

