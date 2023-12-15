package com.ua.logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {
    private final JPAService service;

    public LoggerController(JPAService service) {
        this.service = service;
    }

    @GetMapping(path = "/process/{msg}")
    public ResponseEntity<String> processMessage(
            @PathVariable String msg) {
        String result = service.save(msg);
        return ResponseEntity.ok(result);
    }
}
