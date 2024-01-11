package com.ua.client.controller;

import com.ua.client.model.ClientResponse;
import com.ua.client.model.ProfileResponse;
import com.ua.client.model.ProxyResponse;
import com.ua.client.service.OkHttpClientService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableScheduling
public class ClientRestHttpController
        implements RestHttpController {

    private final OkHttpClientService service;

    public ClientRestHttpController(
            @Qualifier("okHttpClientService") OkHttpClientService service) {
        this.service = service;
    }

    @Override
    public ProfileResponse getProperty(String name, String port) {
        ProxyResponse response = new ProxyResponse(name, port);
        return service.takeCall(response);
    }

    @Override
    public Response postClientProperty(
            List<ProxyResponse> proxies, String etag) {
        ClientResponse client = new ClientResponse(etag);
        return service.makeCall(client, proxies);
    }


    @Override
    public Response postUserProperty(
            ServletRequest request,
            ServletResponse response) {
        return service.newCall((HttpServletRequest) request);
    }

    @Override
    public void sendScheduledProperty() {
        service.takeCall(new ProxyResponse("80", "schedule"));
    }
}
