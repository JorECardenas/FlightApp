package com.encora.flightapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AirportDictionaryItem {

    private String id;

    private String iataCode;

    private String city;



}
