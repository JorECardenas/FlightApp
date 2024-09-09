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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

//import org.threeten.bp.OffsetDateTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class FlightService {


    //private String API_URL = "https://242b3e58-84fd-435b-ba58-5b7589261386.mock.pstmn.io";
    private final String API_URL = "https://test.api.amadeus.com";

    @Value("${api.credential.secret")
    private String CLIENT_SECRET;

    @Value("${api.credential.id}")
    private String CLIENT_ID;

    private String token = "";

    private Instant expires = Instant.now();

    private final int MAX_FLIGHTS = 5;

    private final RestClient client;

    public FlightService(RestClient.Builder builder) {

        this.client = builder.baseUrl(API_URL).build();

    }

    private String getToken() {

        if(Instant.now().isBefore(expires) ){
            return token;
        }


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "client_credentials");
        requestBody.add("client_id", "ni6eYBIZ7R0GsESEYwolDtPlIn0rD8GD");
        requestBody.add("client_secret", "aGjopDNeMnJA0bRJ");

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<AuthToken> response = restTemplate.exchange(API_URL + "/v1/security/oauth2/token", HttpMethod.POST, requestEntity, AuthToken.class);

        token = Objects.requireNonNull(response.getBody()).getAccess_token();
        expires = Instant.now().plus(1499, ChronoUnit.SECONDS);

        return token;
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

    private Map<String, AirportDictionaryItem> getDictionary(Dictionaries dicts) {

        LocationEntry locations = dicts.getLocations();

        Map<String, AirportDictionaryItem> map = new HashMap<>();

        String token = getToken();

        for (String key : locations.keySet()) {

            LocationValue loc = locations.get(key);


            try{
                ResponseEntity<io.swagger.city.Success1> data = client.get()
                        .uri(uriBuilder -> uriBuilder
                                .path("/v1/reference-data/locations")
                                .path("/{cityId}")
                                .build("C" + loc.getCityCode())
                        )
                        .header("Authorization", "Bearer " + token)
                        .retrieve()
                        .toEntity(io.swagger.city.Success1.class);




                map.put(data.getBody().getData().getIataCode() ,
                        new AirportDictionaryItem(data.getBody().getData().getId(),
                                data.getBody().getData().getIataCode(),
                                data.getBody().getData().getName())
                );


                Instant sleep = Instant.now().plus(100, TimeUnit.MILLISECONDS.toChronoUnit());

                while(Instant.now().isBefore(sleep)){
                    continue;
                }
            }catch (HttpClientErrorException e){
                continue;



            }






        }



        return map;


    }

    private List<FlightDetails> parseData(List<FlightOffer> data, Dictionaries dicts) {


        Map<String,AirportDictionaryItem> airports = getDictionary(dicts);


        List<FlightDetails> flights = new ArrayList<>();

        for (FlightOffer offer : data) {

            flights.add(new FlightDetails(offer, airports));

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

        String token = getToken();

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
                .header("Authorization", "Bearer " + token)
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
