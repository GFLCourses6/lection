package com.ua.jpa.service;

import com.ua.jpa.model.Bird;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BirdService {
    Bird create(Bird bird);

    List<Bird> getAll();

    ResponseEntity<Bird> getById(Long id);

    ResponseEntity<List<Bird>> getByName(String name);

    ResponseEntity<Bird> update(Bird bird);

    ResponseEntity<Void> deleteById(Long id);
}
