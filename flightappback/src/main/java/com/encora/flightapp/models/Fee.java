package com.encora.flightapp.models;

import lombok.Data;

@Data
public class Fee {

    String name;

    Float amount;


    public Fee(io.swagger.client.model.Fee fee){
        name = fee.getType().getValue();

        amount = Float.parseFloat(fee.getAmount());
    }

}
