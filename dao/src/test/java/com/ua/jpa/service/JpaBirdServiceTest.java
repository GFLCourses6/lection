package com.ua.jpa.service;

import com.ua.jpa.dao.BirdRepository;
import com.ua.jpa.model.Bird;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class JpaBirdServiceTest {

    @MockBean
    private BirdRepository repository;

    Bird bird = new Bird(111L, "flamingo", "pink");

    @Test
    void testCreate() {
        JpaBirdService service = new JpaBirdService(repository);
        service.create(bird);
        verify(repository, times(1)).save(bird);
    }

    @Test
    void testGetAll() {
        JpaBirdService service = new JpaBirdService(repository);
        service.getAll();
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        JpaBirdService service = new JpaBirdService(repository);
        service.getById(1L);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGetByName() {
        JpaBirdService service = new JpaBirdService(repository);
        service.getByName("flamingo");
        verify(repository, times(1)).findByBird("flamingo");
    }

    @Test
    void testDeleteById() {
        JpaBirdService service = new JpaBirdService(repository);
        service.deleteById(111L);
        verify(repository, times(1)).deleteById(111L);
    }

    @Test
    void testUpdate() {
        JpaBirdService service = new JpaBirdService(repository);
        service.update(bird);
        verify(repository, times(1)).save(bird);
    }

    @Test
    void testDelete() {
        JpaBirdService service = new JpaBirdService(repository);
        when(repository.findById(1L)).thenReturn(Optional.of(bird));
        service.deleteById(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}
