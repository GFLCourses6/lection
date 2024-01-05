package com.ua.jpa.controller;

import com.ua.jpa.model.Authority;
import com.ua.jpa.model.Client;
import com.ua.jpa.model.Role;
import com.ua.jpa.service.IntegrationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/api/web")
public class WebIntegrationController {

    private final IntegrationService service;

    public WebIntegrationController(IntegrationService service) {
        this.service = service;
    }

    @GetMapping(value = "/{clientId}/{type}", produces = "application/json")
    public ResponseEntity<Client> getUrlIntegration(
            @PathVariable Long clientId,
            @PathVariable String type) {
        return service.getClientResponse(clientId, type);
    }

    @GetMapping(value = "/search", produces = "application/json")
    public ResponseEntity<List<Client>> getRequestIntegration(
            @RequestParam Role role) {
        return service.getClientsResponseByRole(role);
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<Client>> getClients() {
        return service.getAll();
    }

    @PostMapping(value = "", produces = "Application/json")
    public ResponseEntity<Client> postIntegration(
            @Valid @RequestBody Client client) {
        return service.postClientResponse(client);
    }

    @PostMapping(value = "/integration", produces = "Application/json")
    public ResponseEntity<List<Client>> postWebIntegration(
            @Valid @RequestBody @NotNull(message = "List Integration") List<Client> clients) {
        return service.postClientResponse(clients);
    }

    @PutMapping(value = "", produces = "Application/json")
    public ResponseEntity<Client> putIntegration(
            @RequestBody Client client) {
        return service.putClientResponse(client);
    }

    @PatchMapping(value = "/{clientId}", produces = "Application/json")
    public ResponseEntity<Client> patchIntegration(
            @PathVariable Long clientId,
            @Valid @RequestBody @NotNull(message = "List Authority") List<Authority> authorities) {
        return service.patchClientResponse(clientId, authorities);
    }

    @DeleteMapping(value = "", produces = "Application/json")
    public ResponseEntity<Void> deleteIntegration() {
        return service.deleteAllClientResponse();
    }
}
