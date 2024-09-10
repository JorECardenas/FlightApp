package com.encora.flightapp.models;

import io.swagger.client.model.ExtendedPrice;
import io.swagger.client.model.FareDetailsBySegment;
import io.swagger.client.model.Price;
import io.swagger.client.model.TravelerPricing;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PriceInfo {

    Float basePrice;

    Float totalPrice;

    String currency;

    TravelerPrice pricePerTraveler;

    List<Fee> fees;


    List<TravelerFare> fares;


    public PriceInfo(ExtendedPrice priceInfo, List<TravelerPricing> travelerPricings){

        basePrice = Float.parseFloat(priceInfo.getBase());
        totalPrice = Float.parseFloat(priceInfo.getGrandTotal());

        fees = null;

        currency = priceInfo.getCurrency();


        pricePerTraveler = new TravelerPrice(travelerPricings.getFirst());


        fares = new ArrayList<>();

        for(FareDetailsBySegment pricing: travelerPricings.getFirst().getFareDetailsBySegment()){

            fares.add(new TravelerFare(pricing));

        }


        fees = new ArrayList<>();

        for(io.swagger.client.model.Fee f: priceInfo.getFees()){
            fees.add(new Fee(f));
        }

    }


}
