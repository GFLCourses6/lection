package org.example.webIntegration;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import java.util.Objects;

// чтобы все аннотации валидации сработали нужно добавить в контроллере @Valid
public class TestObject {
    // Minimum 8 characters,
    // maximum 30 characters,
    // min 1 uppercase letter,
    // min 1 lowercase letter,
    // min 1 number,
    // min 1 special character.
    @Pattern(regexp = "\"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,30}$\"",
            message = ".password error") // regular expression to validate
    private String password;
//    @NotNull // должен постоянно присутствовать
//    @NotEmpty // присутствует но есть пустной
    @NotBlank(message = "type should be present") // проверяет присутствует ли и не пустой
    private String type;
    @Min(value = 3, message = "Id should be min 3")
    @Max(value = 20, message = "Id should be max 20")
    private String id;

    @Valid // ставим чтобы спринг понимал что нужно провалидировать внутренний объект, он знает что нужно провалидировать ентити TestObject и ему нужно указать еще и внутренние
    @NotNull(message = "inner object not be null")
    private TestSecondObject object; // validate custom object

    @Valid // ставим чтобы спринг понимал что нужно провалидировать внутренний объект, он знает что нужно провалидировать ентити TestObject и ему нужно указать еще и внутренние
    @NotNull(message = "inner object list not be null")
    private List<TestSecondObject> list;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TestSecondObject getObject() {
        return object;
    }

    public void setObject(TestSecondObject object) {
        this.object = object;
    }

    public List<TestSecondObject> getList() {
        return list;
    }

    public void setList(List<TestSecondObject> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestObject that = (TestObject) o;
        return Objects.equals(password, that.password) && Objects.equals(type, that.type) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, type, id);
    }
}
