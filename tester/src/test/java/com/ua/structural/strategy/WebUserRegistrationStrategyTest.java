package com.ua.structural.strategy;

import com.ua.dto.model.dto.Login;
import com.ua.dto.model.dto.Role;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class WebUserRegistrationStrategyTest {

    static List<Login> users = Arrays.asList(
            new Login("admin", Arrays.asList(Role.ADMIN, Role.USER)),
            new Login("editor", Arrays.asList(Role.EDITOR, Role.USER)),
            new Login("User", Collections.singletonList(Role.USER))
    );

    @Test
    void onlyOneUserMayBeEditor() {
        List<Login> users = searchUsersByRole(Role.EDITOR);
        assertThat(users).hasSingleUserInRole(Role.EDITOR);
    }

    static UserAssert assertThat(List<Login> users) {
        return new UserAssert(users);
    }

    static List<Login> searchUsersByRole(Role role) {
        return users.stream()
                    .filter(user -> user.getRoles().contains(role))
                    .collect(Collectors.toList());
    }
}
