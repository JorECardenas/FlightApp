package com.encora.flightapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class TravelerFare {

    String cabin;

    String seatClass;

    ArrayList<Ammenity> ammenities;


}
