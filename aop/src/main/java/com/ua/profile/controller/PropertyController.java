package com.ua.profile.controller;

import com.ua.profile.model.PropertyField;
import com.ua.profile.service.PropertyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/property")
public class PropertyController {

    private final PropertyService first;
    private final PropertyService second;

    public PropertyController(
            @Qualifier("FirstService") PropertyService first,
            @Qualifier("SecondService") PropertyService second) {
        this.first = first;
        this.second = second;
    }

    @GetMapping(value = "/first", produces = "Application/json")
    public ResponseEntity<PropertyField> getFirstProperty() {
        return ResponseEntity.ok(first.getProperty());
    }

    @GetMapping(value = "/second", produces = "Application/json")
    public ResponseEntity<PropertyField> getSecondProperty() {
        return ResponseEntity.ok(second.getProperty());
    }
}
