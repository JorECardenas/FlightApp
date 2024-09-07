package com.encora.flightapp.models;

import io.swagger.client.model.ExtendedPrice;
import io.swagger.client.model.Price;
import io.swagger.client.model.TravelerPricing;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PriceInfo {

    Float basePrice;

    Float totalPrice;

    Float fees;

    Float pricePerTraveler;

    public PriceInfo(ExtendedPrice priceInfo, List<TravelerPricing> travelerPricings){

        basePrice = Float.parseFloat(priceInfo.getBase());
        totalPrice = Float.parseFloat(priceInfo.getGrandTotal());

        fees = null;


        pricePerTraveler = totalPrice / travelerPricings.size();






    }


}
