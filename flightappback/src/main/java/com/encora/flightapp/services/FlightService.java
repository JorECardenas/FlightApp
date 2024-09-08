package com.encora.flightapp.services;

import com.encora.flightapp.models.AirportDictionaryItem;
import com.encora.flightapp.models.FlightDetails;
import com.encora.flightapp.models.auth.AuthBody;
import com.encora.flightapp.models.auth.AuthToken;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.client.ApiResponse;
import io.swagger.client.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

//import org.threeten.bp.OffsetDateTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {


    private String API_URL = "https://242b3e58-84fd-435b-ba58-5b7589261386.mock.pstmn.io";
    //private String API_URL = "https://test.api.amadeus.com";

    @Value("${api.credential.secret")
    private String CLIENT_SECRET;

    @Value("${api.credential.id}")
    private String CLIENT_ID;

    private final int MAX_FLIGHTS = 5;

    private final RestClient client;

    public FlightService(RestClient.Builder builder) {

        this.client = builder.baseUrl(API_URL).build();

    }


    private String getToken() {

        String GRANT_TYPE = "client_credentials";
        AuthBody body = new AuthBody(CLIENT_ID, CLIENT_SECRET, GRANT_TYPE);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", GRANT_TYPE);
        map.add("client_id", CLIENT_ID);
        map.add("client_secret", CLIENT_SECRET);

        String authToken = "";

        try {
            String data = client.post()
                    .uri("/v1/security/oauth2/token")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(map)
                    .retrieve()
                    .body(String.class);

            ObjectMapper mapper = getPerfectObjectMapper();


            AuthToken token = mapper.readValue(data, AuthToken.class);

            authToken = token.getAccess_token();


        } catch (Exception e) {
            throw new RuntimeException();
        }


        return authToken;
    }

    public ObjectMapper getPerfectObjectMapper() {

        final ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));

        mapper.registerModule(new JavaTimeModule());


        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDateTime.class, new CustomDateDeserializer());
        mapper.registerModule(module);

        return mapper;

    }

    private List<AirportDictionaryItem> getDictionary(Dictionaries dicts) {

        LocationEntry locations = dicts.getLocations();

        List<AirportDictionaryItem> names = new ArrayList<>();

        ObjectMapper mapper = getPerfectObjectMapper();

        //String token = getToken();

        for (String key : locations.keySet()) {

            LocationValue loc = locations.get(key);

            io.swagger.city.Success data = client.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/v1/reference-data/locations")
                            .queryParam("subType", "CITY")
                            .queryParam("keyword", loc.getCityCode())
                            .queryParam("countryCode", loc.getCountryCode())
                            .queryParam("view", "LIGHT")
                            .build()
                    )
                    //.header("Authorization", "Bearer " + token)
                    .retrieve()
                    .body(io.swagger.city.Success.class);

            if (data != null && data.getData().isEmpty()) {
                continue;
            }

            names.add(new AirportDictionaryItem(data.getData().getFirst().getId(),
                    data.getData().getFirst().getIataCode(),
                    data.getData().getFirst().getName()));




        }

        System.out.println(names);

        return names;


    }


    private List<FlightDetails> parseData(List<FlightOffer> data, Dictionaries dicts) {


        List<AirportDictionaryItem> airports = getDictionary(dicts);


        List<FlightDetails> flights = new ArrayList<>();

        for (FlightOffer offer : data) {

            flights.add(new FlightDetails(offer));

        }


        return flights;


    }

    public List<FlightDetails> getFromAPI(String DepAirport,
                                          String ArrAirport,
                                          String DepDate,
                                          String ArrDate,
                                          int NumAdults,
                                          String Currency,
                                          boolean NonStop) {

        //String token = getToken();

        String data = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v2/shopping/flight-offers")
                        .queryParam("originLocationCode", DepAirport)
                        .queryParam("destinationLocationCode", ArrAirport)
                        .queryParam("departureDate", DepDate)
                        .queryParam("returnDate", ArrDate)
                        .queryParam("adults", NumAdults)
                        .queryParam("currencyCode", Currency)
                        .queryParam("nonStop", NonStop)
                        .queryParam("max", MAX_FLIGHTS)
                        .build()
                )
                //.header("Authorization", "Bearer " + token)
                .retrieve()
                .body(String.class);


        ObjectMapper mapper = getPerfectObjectMapper();

        List<FlightDetails> flights = new ArrayList<>();

        try {
            Success success = mapper.readValue(data, Success.class);

            flights = parseData(success.getData(), success.getDictionaries());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return flights;


    }


}
