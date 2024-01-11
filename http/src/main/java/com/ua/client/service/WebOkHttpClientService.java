package com.ua.client.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ua.client.model.ClientResponse;
import com.ua.client.model.ProfileResponse;
import com.ua.client.model.ProxyResponse;
import jakarta.servlet.http.HttpServletRequest;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class WebOkHttpClientService
        implements OkHttpClientService {

        private static final Logger LOGGER = LoggerFactory.getLogger(WebOkHttpClientService.class);

    @Value("${post.uri}")
    private String uri;

    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.keycloak.client_secret}")
    private String clientSecret;

    private final OkHttpClient okHttpClient;
    private final WebClient.Builder webClientBuilder;

    public WebOkHttpClientService(
            OkHttpClient okHttpClient,
            WebClient.Builder webClientBuilder) {
        this.okHttpClient = okHttpClient;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public ProfileResponse takeCall(ProxyResponse proxy) {
        return webClientBuilder.build()
                               .post()
                               .uri(uri + "/property/" + proxy.getPort() + "/"+ proxy.getName())
                               .retrieve()
                               .bodyToMono(ProfileResponse.class)
                               .block();
    }

    @Override
    public Response newCall(HttpServletRequest request)  {
        try {
            return okHttpClient.newCall(createOkHttpRequest(request)).execute();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    private Request createOkHttpRequest(
            HttpServletRequest request) throws IOException {
        Headers headers = extractHeaders(request);
        String requestBody = extractRequestBody(request);
        return sendRequest("/user", headers, requestBody);
    }

    @NotNull
    private Request sendRequest(String path, Headers headers, String requestBody) {
        return new okhttp3.Request.Builder()
                .url(uri + path)
                .headers(headers)
                .post(RequestBody.create(requestBody, MediaType.parse("application/json")))
                .addHeader(clientId, clientSecret)
                .build();
    }

    private Headers extractHeaders(HttpServletRequest servletRequest) {
        Enumeration<String> headerNames = servletRequest.getHeaderNames();
        okhttp3.Headers.Builder headersBuilder = new okhttp3.Headers.Builder();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = servletRequest.getHeader(headerName);
            headersBuilder.add(headerName, headerValue);
        }
        return headersBuilder.build();
    }

    private String extractRequestBody(
            HttpServletRequest servletRequest) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(servletRequest.getInputStream(),
                                      StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }
        return requestBody.toString();
    }

    @Override
    public Response makeCall(
            ClientResponse clientResponse,
            List<ProxyResponse> proxyResponses) {
        OkHttpClient client = getOkHttpClient();
        Headers headers = new Headers.Builder()
                .add("clientId", clientId)
                .add("clientSecret", clientSecret)
                .build();
        try {
            Request request = sendRequest("/property", headers, prepareRequest());
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    LOGGER.info("{}", (response.code()));
                    ResponseBody body = response.body();
                    if (body != null) {
                        LOGGER.info("{}", new ObjectMapper()
                                .readValue(body.byteStream(),
                                           ProfileResponse.class));
                    } else {
                        LOGGER.warn("Null response body");
                    }
                } else {
                    LOGGER.warn("Unsuccessful response: {}", response.code());
                }
                return response;
            }
        } catch (IOException e) {
            LOGGER.error("Error making call: {}", e.getMessage(), e);
            return null;
        }
    }

    @NotNull
    private static OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(1000, TimeUnit.MILLISECONDS)
                .writeTimeout(1000, TimeUnit.MILLISECONDS)
                .build();
    }

    private String prepareRequest()
            throws JsonProcessingException {
        Map<String, String> values = Map.of("etag",
                                            "12345",
                                            "name",
                                            "Roger Moose",
                                            "url",
                                            uri + "/property",
                                            "port",
                                            "9000");
        var objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(values);
    }
}
