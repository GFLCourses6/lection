package com.ua.structural.strategy;

import com.ua.dto.model.dto.Login;
import com.ua.dto.model.dto.Role;
import org.assertj.core.api.AbstractAssert;

import java.util.List;

public class UserAssert
        extends AbstractAssert<UserAssert, List<Login>> {

    public UserAssert(List<Login> users) {
        super(users, UserAssert.class);
    }

    public UserAssert hasSingleUserInRole(Role role) {
        isNotNull();
        long count = actual
                .stream()
                .filter(user -> user.getRoles().contains(role))
                .count();
        if (count != 1) {
            failWithMessage(
                    "Expected a single user with role <%s> but found <%d>.",
                    role,
                    count);
        }
        return this;
    }
}

