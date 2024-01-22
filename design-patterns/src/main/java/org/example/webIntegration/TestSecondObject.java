package org.example.webIntegration;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class TestSecondObject {
    @NotBlank(message = "Inner type should not be empty")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestSecondObject that = (TestSecondObject) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
