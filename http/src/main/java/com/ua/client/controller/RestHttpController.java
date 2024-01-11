package com.ua.client.controller;

import com.ua.client.model.ProfileResponse;
import com.ua.client.model.ProxyResponse;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import okhttp3.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RestHttpController {

    @GetMapping(value = "api/client", produces = "application/json")
    ProfileResponse getProperty(
            @RequestParam(value = "port", required = false, defaultValue ="80") String port,
            @RequestParam(value = "name", defaultValue ="client") String name);

    @PostMapping("api/client")
    Response postClientProperty(
            @RequestBody List<ProxyResponse> proxies,
            @RequestHeader(name = HttpHeaders.IF_NONE_MATCH, required = false) String etag);

    @PostMapping("api/user/")
    Response postUserProperty(
            ServletRequest request,
            ServletResponse response);

    @Scheduled(fixedRate = 2000)
    @GetMapping(value = "", produces = "application/json")
    void sendScheduledProperty();
}
