package com.ua.client.model;

import java.util.Objects;

public class ProxyResponse {
    private String name;
    private String port;

    public ProxyResponse(
            String port,
            String name) {
        this.name = name;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProxyResponse that = (ProxyResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(port,
                                                                 that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, port);
    }

    @Override
    public String toString() {
        return "ProxyResponse{" + "name='" + name + '\'' + ", port='" + port + '\'' + '}';
    }
}
