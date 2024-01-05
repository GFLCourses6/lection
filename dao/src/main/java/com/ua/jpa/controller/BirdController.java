package com.ua.jpa.controller;

import com.ua.jpa.model.Bird;
import com.ua.jpa.service.BirdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/birds")
public class BirdController {

    private final BirdService service;

    public BirdController(BirdService service) {
        this.service = service;
    }

    @GetMapping(value = "/all", produces = "Application/json")
    public List<Bird> getAllBirds(){
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = "Application/json")
    public ResponseEntity<Bird> getById(
            @PathVariable(name="id") Long id) {
        return service.getById(id);
    }

    @GetMapping(value = "/by/{name}", produces = "Application/json")
    public ResponseEntity<List<Bird>> getByName(
            @PathVariable(name="name") String name){
        return service.getByName(name);
    }

    @PostMapping(value = "/add", produces = "Application/json")
    public Bird saveBird(
            @RequestBody Bird bird){
        return service.create(bird);
    }

    @PutMapping(value = "/update", produces = "Application/json")
    public ResponseEntity<Bird> updateBird(
            @RequestBody Bird bird){
        return service.update(bird);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "Application/json")
    public ResponseEntity<Void> deleteBird(
            @PathVariable(name="id") Long id){
        return service.deleteById(id);
    }
}
