package com.ua.client.model;

import java.util.Objects;

public class ClientResponse {
    private String name;
    private String etag;

    public ClientResponse(String etag) {
        this.etag = etag;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientResponse that = (ClientResponse) o;
        return Objects.equals(name, that.name)
                && Objects.equals(etag, that.etag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, etag);
    }
}
