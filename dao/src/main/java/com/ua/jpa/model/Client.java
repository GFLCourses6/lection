package com.ua.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long id;

    @NotBlank
    @Size(min = 1, message = "Name must have at least 1 character")
    private String name;

    @NotNull(message = "Password cannot be null")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Password must match the specified pattern")
    private String password;

    @NotNull(message = "Age cannot be null")
    @Min(value = 3, message = "Age must be at least 3")
    @Max(value = 100, message = "Age must be at most 100")
    @Pattern(regexp = "\\d+", message = "Age must be a number")
    private Integer age;

    @NotEmpty(message = "Roles cannot be empty")
    @ManyToMany(mappedBy = "clients")
    private List<Authority> authorities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void addAuthorities(List<Authority> authorities) {
        this.authorities.addAll(authorities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name,
                                                               client.name) && Objects.equals(
                password,
                client.password) && Objects.equals(age, client.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, age);
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + ", age=" + age + ", authorities=" + authorities + ", role=" + role + '}';
    }

}
