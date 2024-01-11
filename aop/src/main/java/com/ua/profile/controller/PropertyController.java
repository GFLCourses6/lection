package com.ua.profile.controller;

import com.ua.profile.model.PropertyResponse;
import com.ua.profile.service.PropertyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/property")
public class PropertyController {

    private final PropertyService first;
    private final PropertyService second;

    public PropertyController(
            @Qualifier("firstService") PropertyService first,
            @Qualifier("secondService") PropertyService second) {
        this.first = first;
        this.second = second;
    }

    @GetMapping(value = "/dev", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Queue<PropertyResponse>> getFirstProperty() {
        return ResponseEntity.ok(first.getProperties());
    }

    @GetMapping(value = "/prod", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Queue<PropertyResponse>> getSecondProperty() {
        return ResponseEntity.ok(second.getProperties());
    }

    @PostMapping(value = "/{port}/{name}")
    public ResponseEntity<PropertyResponse> createFirstProperty(
            @PathVariable("port") String port,
            @PathVariable("name") String name) {
        return ResponseEntity.ok(first.addProperty(port, name));
    }

    @GetMapping(value = "/prod/port", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PropertyResponse> pollSecondProperty() {
        return ResponseEntity.ok(second.pollProperty());
    }
}
