package com.vladproduction.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @GetMapping("/call-microservice-1")
    public String getResponse(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http:localhost:8080/api/property1")
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
