package com.ua.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileResponse {

    @JsonProperty("profile")
    private String profile;

    @JsonProperty("name")
    private String name;

    @JsonProperty("port")
    private String port;

    public ProfileResponse() {
    }

    public ProfileResponse(
            String profile,
            String name,
            String port) {
        this.profile = profile;
        this.name = name;
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileResponse that = (ProfileResponse) o;
        return Objects.equals(profile, that.profile) && Objects.equals(name, that.name)
                && Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profile, name, port);
    }
}
