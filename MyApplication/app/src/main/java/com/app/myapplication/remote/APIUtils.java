package com.app.myapplication.remote;

public class APIUtils {
    private APIUtils(){
    };

    public static final String API_URL = "'/restfinal/webresources/";

    public static PersonaService getUserService(){
        return RetrofitClient.getClient(API_URL).create(PersonaService.class);
    }
}
