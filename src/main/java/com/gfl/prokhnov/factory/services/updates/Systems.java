package com.gfl.prokhnov.factory.services.updates;

import java.util.Objects;

public abstract class Systems {
    protected String model;

    public Systems(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Systems systems = (Systems) o;
        return Objects.equals(model, systems.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    @Override
    public String toString() {
        return "System{" +
                "model='" + model + '\'' +
                '}';
    }
}
