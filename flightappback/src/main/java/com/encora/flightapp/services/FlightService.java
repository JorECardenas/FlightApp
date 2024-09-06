package com.encora.flightapp.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.client.model.Success;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

//import org.threeten.bp.OffsetDateTime;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import java.text.SimpleDateFormat;

@Service
public class FlightService {


    @Value("${api.url.test}")
    private String url;

    @Value("${api.credential.secret")
    private String credential;

    @Value("${api.credential.id}")
    private String id;

    private final RestClient client;

    public FlightService(RestClient.Builder builder){

        this.client = builder.baseUrl(url).build();

    }



    private JSONObject parseData(String json){


        JSONParser parser = new JSONParser();
        try{
            JSONObject obj = (JSONObject) parser.parse(json);

            JSONArray data = (JSONArray) obj.get("data");

            return obj;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }




    }


    private String getToken(){
        String data = client.get().uri(url + "/v1/security/oauth2/token").retrieve().body(String.class);

        return "token";
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
        module.addDeserializer(LocalDate.class, new CustomDateDeserializer());
        mapper.registerModule(module);

        return mapper;

    }


    public String getFromAPI(){
        String data = client.get().uri(url + "/v2/shopping/flight-offers").retrieve().body(String.class);

        System.out.println(data);

        ObjectMapper mapper = getPerfectObjectMapper();

        try{
            Success success = mapper.readValue(data, Success.class);

            System.out.println(success.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        return data;






    }



}
