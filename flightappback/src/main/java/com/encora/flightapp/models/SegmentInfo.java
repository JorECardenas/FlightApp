package com.encora.flightapp.models;

import jakarta.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;

public class SegmentInfo {

    Date depDate;
    Date arrDate;

    String airline;

    String flightNumber;

    @Nullable
    String carrier;

    String aircraftType;

    ArrayList<TravelerFare> fares;

    @Nullable
    String waitTime;
}
