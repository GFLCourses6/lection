package com.ua.db.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.ua.db.service.Query.DELETE;
import static com.ua.db.service.Query.INSERT;
import static com.ua.db.service.Query.SELECT_ALL;
import static com.ua.db.service.Query.SELECT_BY;
import static com.ua.db.service.Query.UPDATE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BirdCrudDBServiceTest {

    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement statement;
    @Mock
    private ResultSet resultSet;
    private BirdCrudDBService service;
    private List<Bird> birds;
    private List<Integer> ids;
    private List<String> names;
    private List<String> desc;

    @BeforeEach
    void setUp()
            throws SQLException {
        MockitoAnnotations.openMocks(this);
        service = new BirdCrudDBService(connection);
        when(connection.prepareStatement(SELECT_ALL)).thenReturn(statement);
        when(statement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(SELECT_BY)).thenReturn(statement);
        when(statement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(INSERT)).thenReturn(statement);
        when(connection.prepareStatement(UPDATE)).thenReturn(statement);
        when(connection.prepareStatement(DELETE)).thenReturn(statement);
        birds = List.of(new Bird(1, "pigeon", "Common city bird with gray feathers."),
                        new Bird(2, "eagle", "Large bird of prey with a strong beak and talons."),
                        new Bird(3, "rooster", "Male chicken known for its crowing at dawn."),
                        new Bird(4, "sparrow", "Small bird with brown and gray plumage."),
                        new Bird(5, "owl", "Nocturnal bird of prey with a distinctive hooting sound."));
        ids = birds.stream().map(Bird::id).toList();
        names = birds.stream().map(Bird::name).toList();
        desc = birds.stream().map(Bird::description).toList();
    }

    @AfterEach
    void tearDown()
            throws SQLException {
        service.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)
    void testGetFilterBirds(int id, String name, String description, int expected) throws SQLException {
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getInt("id")).thenReturn(id);
        when(resultSet.getString("bird")).thenReturn(name);
        when(resultSet.getString("description")).thenReturn(description);
        Bird bird = new Bird(id, name, description);
        List<Bird> actual = service.getFilterBirds(name);
        verify(connection).prepareStatement(SELECT_BY);
        verify(statement).setString(1, name);
        verify(statement).executeQuery();
        assertEquals(expected, actual.size());
        assertEquals(bird, birds.get(id - 1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)
    void testInsertBird(int id, String name, String description, int expected) throws SQLException {
        Bird bird = new Bird(id, name, description);
        assertNotNull(bird);
        when(statement.executeUpdate()).thenReturn(expected);
        int result = service.insertBird(name, description);
        verify(connection).prepareStatement(INSERT);
        verify(statement).setString(1, name);
        verify(statement).setString(2, description);
        verify(statement).executeUpdate();
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)
    void testUpdateBird(int id, String name, String description, int expected) throws SQLException {
        when(statement.executeUpdate()).thenReturn(expected);
        int result = service.updateBird(name, description);
        verify(connection).prepareStatement(UPDATE);
        verify(statement).setString(1, description);
        verify(statement).setString(2, name);
        verify(statement).executeUpdate();
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)
    void testDeleteBird(int id, String name, String description, int expected) throws SQLException {
        Bird bird = new Bird(id, name, description);
        assertNotNull(bird);
        when(statement.executeUpdate()).thenReturn(expected);
        int result = service.deleteBird(bird.name());
        verify(connection).prepareStatement(DELETE);
        verify(statement).setString(1, name);
        verify(statement).executeUpdate();
        assertEquals(expected, result);
    }

    @Test
    void testGetAllBirds() throws SQLException {
        when(resultSet.next()).thenReturn(true, true, true, true, true, false);
        when(resultSet.getInt("id")).thenReturn(ids.get(0), ids.get(1), ids.get(2), ids.get(3), ids.get(4));
        when(resultSet.getString("bird")).thenReturn(names.get(0), names.get(1), names.get(2), names.get(3), names.get(4));
        when(resultSet.getString("description")).thenReturn(desc.get(0), desc.get(1), desc.get(2), desc.get(3), desc.get(4));
        List<Bird> result = service.getAllBirds();
        verify(connection).prepareStatement(SELECT_ALL);
        verify(statement).executeQuery();
        assertEquals(birds, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 3)
    void testGetFilterBirdsByName(int id, String name, String description, int expected)
            throws SQLException {
        Bird bird = new Bird(id, name, description);
        when(resultSet.next()).thenReturn(true, true, false);
        when(resultSet.getInt("id")).thenReturn(ids.get(3), ids.get(4));
        when(resultSet.getString("bird")).thenReturn(names.get(3), names.get(4));
        when(resultSet.getString("description")).thenReturn(desc.get(3), desc.get(4));
        List<Bird> result = service.getFilterBirds(bird.name());
        verify(connection).prepareStatement(SELECT_BY);
        verify(statement).setString(1, bird.name());
        verify(statement).executeQuery();
        List<Bird> expectedBirds = birds.subList(3, 5);
        assertEquals(expectedBirds, result);
    }

    @Test
    void testUpdateBird() throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);
        int result = service.updateBird("eagle", "Powerful bird of prey with a keen eyesight.");
        verify(connection).prepareStatement(UPDATE);
        verify(statement).setString(1, "Powerful bird of prey with a keen eyesight.");
        verify(statement).setString(2, "eagle");
        verify(statement).executeUpdate();
        assertEquals(1, result);
    }

    @Test
    void testDeleteBird() throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);
        int result = service.deleteBird("sparrow");
        verify(connection).prepareStatement(DELETE);
        verify(statement).setString(1, "sparrow");
        verify(statement).executeUpdate();
        assertEquals(1, result);
    }
}
