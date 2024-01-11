package com.ua.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ua.client.model.ClientResponse;
import com.ua.client.model.ProfileResponse;
import com.ua.client.model.ProxyResponse;
import com.ua.client.service.OkHttpClientService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/web")
public class HttpCliClientController
        implements CliClientController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HttpCliClientController.class);
    private final ObjectReader objectReader;
    private final ObjectWriter objectWriter;
    private final RestTemplate restTemplate;
    private final OkHttpClientService httpClientService;
    private static final String URI = "http://localhost:8085/api/property?";

    public HttpCliClientController(
            RestTemplate restTemplate,
            @Qualifier("okHttpClientService") OkHttpClientService httpClientService,
            ObjectMapper objectMapper) {
        this.objectReader = objectMapper.readerFor(ProxyResponse.class);
        this.objectWriter = objectMapper.writerFor(ClientResponse.class);
        this.restTemplate = restTemplate;
        this.httpClientService = httpClientService;
    }

    @Override
    public ProfileResponse getProperty(
            String number,
            String port) {
        String url = URI + "number={number}";
        Map<String, String> httpParams = new HashMap<>();
        httpParams.put("number", number);
        httpParams.put("port", port);
        return restTemplate.getForObject(url, ProfileResponse.class, httpParams);
    }

    @Override
    public Response postClientProperty(
            List<ProxyResponse> proxies,
            String etag) {
            ClientResponse user = new ClientResponse(etag);
            return httpClientService.makeCall(user, proxies);
    }

    @Override
    public Response postUserProperty(
            ServletRequest request,
            ServletResponse servletResponse) {
        return httpClientService.newCall((HttpServletRequest) request);
    }

    @Override
    public void sendScheduledProperty() {
        String url = URI + "name=schedule&port8085";
        LOGGER.info("{}", restTemplate.getForEntity(url, String.class));
    }
}
