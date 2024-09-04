package com.encora.flightapp.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

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

        this.client = builder.baseUrl(this.url).build();

    }

    private JSONObject parseData(String json){


        JSONParser parser = new JSONParser();
        try{
            JSONObject obj = (JSONObject) parser.parse(json);

            JSONArray data = (JSONArray) obj.get("data");



            System.out.println(data);




            return obj;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }




    }


    public String getFromAPI(){
        String data = client.get().uri(url + "/v2/shopping/flight-offers").retrieve().body(String.class);

        parseData(data);

        return data;






    }



}
