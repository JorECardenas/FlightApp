package com.encora.flightapp.models.auth;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

import lombok.Data;

@Data
public class AuthToken{
    public String type;
    public String username;
    public String application_name;
    public String client_id;
    public String token_type;
    public String access_token;
    public int expires_in;
    public String state;
    public String scope;
}


