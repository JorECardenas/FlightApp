package com.encora.flightapp.models;

import io.swagger.client.model.TravelerPricing;
import lombok.Data;

@Data
public class TravelerPrice {

    Float basePrice;
    Float totalPrice;

    String fareOption;

    public TravelerPrice(TravelerPricing pricing)
    {
        basePrice = Float.parseFloat(pricing.getPrice().getBase());
        totalPrice = Float.parseFloat(pricing.getPrice().getTotal());

        fareOption = pricing.getFareOption().getValue();
    }



}
