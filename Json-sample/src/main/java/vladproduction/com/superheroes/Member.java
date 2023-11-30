package vladproduction.com.superheroes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Member {

    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;
    @JsonProperty("secretIdentity")
    private String secretIdentity;
    @JsonProperty("powers")
    private List<String> powers;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public List<String> getPowers() {
        return powers;
    }

    public void setPowers(List<String> powers) {
        this.powers = powers;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", secretIdentity='" + secretIdentity + '\'' +
                ", powers=" + powers +
                '}' + "\n";
    }
}
