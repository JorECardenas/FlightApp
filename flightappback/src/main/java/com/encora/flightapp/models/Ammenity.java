package com.encora.flightapp.models;

import io.swagger.client.model.Amenity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ammenity {

    String name;

    Boolean chargeable;

    public Ammenity(Amenity am){

        name = am.getDescription();

        chargeable = am.getIsChargeable();

    }

}
