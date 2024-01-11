package com.ua.profile.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyResponse {

    @JsonProperty("profile")
    private String profile;

    @JsonProperty("name")
    private String name;

    @JsonProperty("port")
    private String port;

    public PropertyResponse(
            String profile,
            String name,
            String port) {
        this.profile = profile;
        this.name = name;
        this.port = port;
    }

    public String getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }

    public String getPort() {
        return port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyResponse that = (PropertyResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, port);
    }

    @Override
    public String toString() {
        return "PropertyResponse{profile='%s', name='%s', port='%s'}"
                .formatted(profile, name, port);
    }
}
