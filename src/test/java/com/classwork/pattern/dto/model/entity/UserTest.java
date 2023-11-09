package com.classwork.pattern.dto.model.entity;

import com.classwork.pattern.dto.model.dto.LoginRecord;
import com.classwork.pattern.proxy.logger.LoginArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    @ParameterizedTest
    @ArgumentsSource(LoginArgumentsProvider.class)
    void testEqualsAndHashCodeUser(String firstName, String lastName, Long id) {
        User user1 = new User(id.intValue(), firstName, lastName);
        User user2 = new User(id.intValue(), firstName, lastName);
        assertTrue(user1.equals(user2) && user2.equals(user1));
        assertEquals(user1.hashCode(), user2.hashCode());

        user2.addShip(new Ship("Black Pearl"));
        assertFalse(user1.equals(user2) || user2.equals(user1));
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }

    @ParameterizedTest
    @ArgumentsSource(LoginArgumentsProvider.class)
    void testEqualsAndHashCode(String firstName, String lastName, Long id) {
        User user1 = new User(id.intValue(), firstName, lastName);
        LoginRecord dto1 = new LoginRecord(firstName, lastName, id);
        User user2 = new User(id.intValue(), firstName, lastName);
        LoginRecord dto2 = new LoginRecord(firstName, lastName, id);

        assertTrue(user1.equals(user2) && user2.equals(user1));
        assertTrue(dto1.equals(dto2) && dto2.equals(dto1));
    }

}