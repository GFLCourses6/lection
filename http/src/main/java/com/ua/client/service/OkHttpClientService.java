package com.ua.client.service;

import com.ua.client.model.ClientResponse;
import com.ua.client.model.ProfileResponse;
import com.ua.client.model.ProxyResponse;
import jakarta.servlet.http.HttpServletRequest;
import okhttp3.Response;

import java.util.List;

public interface OkHttpClientService {

    Response makeCall(
            ClientResponse client,
            List<ProxyResponse> response);

    Response newCall(HttpServletRequest request);

    ProfileResponse takeCall(ProxyResponse proxy);
}
