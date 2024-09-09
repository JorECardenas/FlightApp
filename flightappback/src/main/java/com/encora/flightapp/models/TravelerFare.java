package com.encora.flightapp.models;

import io.swagger.client.model.Amenity;
import io.swagger.client.model.FareDetailsBySegment;
import io.swagger.client.model.TravelerPricing;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class TravelerFare {

    String flightId;

    String cabin;

    String seatClass;

    ArrayList<Ammenity> ammenities;

    public TravelerFare(FareDetailsBySegment fare){

        flightId = fare.getSegmentId();


        cabin = fare.getCabin().getValue();

        seatClass = fare.getPropertyClass();

        ammenities = new ArrayList<>();

        if(fare.getAmenities() != null){
            for(Amenity am: fare.getAmenities()){
                ammenities.add(new Ammenity(am));
            }
        }




    }


}
