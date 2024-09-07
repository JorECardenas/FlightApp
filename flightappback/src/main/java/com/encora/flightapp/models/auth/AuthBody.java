package com.encora.flightapp.models.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthBody {

    public String client_id;

    public String client_secret;

    public String grant_type;


}
