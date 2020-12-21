package com.app.myapplication.remote;

public class APIUtils {
    private APIUtils(){
    };

    public static final String API_URL = "http://187.148.100.61:8084/restfinal/webresources/";

    public static PersonaService getUserService(){
        return RetrofitClient.getClient(API_URL).create(PersonaService.class);
    }
}
