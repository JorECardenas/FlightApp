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
import java.util.Map;

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



    public SegmentInfo(Itineraries segment, List<TravelerPricing> pricings, Map<String,AirportDictionaryItem> dict){

        time = segment.getDuration();

        depDate = segment.getSegments().getFirst().getDeparture().getAt();

        arrDate = segment.getSegments().getLast().getArrival().getAt();

        if(dict.get(segment.getSegments().getFirst().getDeparture().getIataCode()) == null){
            depAirport = segment.getSegments().getFirst().getDeparture().getIataCode();
        }else {
            depAirport = dict.get(segment.getSegments().getFirst().getDeparture().getIataCode()).getCity() + " (" + segment.getSegments().getFirst().getDeparture().getIataCode() +")";

        }

        if(dict.get(segment.getSegments().getLast().getArrival().getIataCode()) == null){
            arrAirport = segment.getSegments().getLast().getArrival().getIataCode();
        }else {
            arrAirport = dict.get(segment.getSegments().getLast().getArrival().getIataCode()).getCity() + " (" + segment.getSegments().getLast().getArrival().getIataCode() +")";

        }


        //arrAirport = dict.get(segment.getSegments().getLast().getArrival().getIataCode()).getCity() + " (" + segment.getSegments().getLast().getArrival().getIataCode() +")";


        stops = new ArrayList<>();

        for(int i = 1; i <= segment.getSegments().size() - 1; i++){

            System.out.println(segment.getSegments().get(i).getDeparture().getIataCode());

            String airport = segment.getSegments().get(i).getDeparture().getIataCode();

            if(dict.get(segment.getSegments().get(i).getDeparture().getIataCode()) != null){
                airport = dict.get(segment.getSegments().get(i).getDeparture().getIataCode()).getCity() + " (" + segment.getSegments().get(i).getDeparture().getIataCode() +")";

            }

            //String airport = dict.get(segment.getSegments().get(i).getDeparture().getIataCode()).getCity() + " (" + segment.getSegments().getFirst().getDeparture().getIataCode() +")";


            LocalDateTime start = segment.getSegments().get(i - 1).getArrival().getAt();
            LocalDateTime end = segment.getSegments().get(i).getDeparture().getAt();

            Duration diff = Duration.between(start, end);

            stops.add(new FlightStop(airport, diff.toString()));

        }

        fares = new ArrayList<>();







    }
}

