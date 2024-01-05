package com.ua.jpa.service;

import com.ua.jpa.dao.BirdRepository;
import com.ua.jpa.exception.BirdNotFoundException;
import com.ua.jpa.model.Bird;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaBirdService
        implements BirdService {

    private final BirdRepository repository;

    public JpaBirdService(BirdRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bird create(Bird bird) {
        return repository.save(bird);
    }

    @Override
    public List<Bird> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Bird> getById(Long id) {
        return repository.findById(id)
                         .map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Bird>> getByName(String name) {
        List<Bird> birds = repository.findByBird(name);
        return !birds.isEmpty()
               ? ResponseEntity.ok(birds)
               : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Bird> update(Bird bird) {
        try {
            return ResponseEntity.ok(repository.save(bird));
        } catch (BirdNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (BirdNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
