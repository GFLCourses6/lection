package com.ua.jpa.service;

import com.ua.jpa.model.Authority;
import com.ua.jpa.model.Client;
import com.ua.jpa.model.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IntegrationService {
    ResponseEntity<Client> getClientResponse(Long clientId, String type);

    ResponseEntity<List<Client>> getClientsResponseByRole(Role role);

    ResponseEntity<List<Client>> getAll();

    ResponseEntity<Client> postClientResponse(Client client);

    ResponseEntity<List<Client>> postClientResponse(List<Client> clients);

    ResponseEntity<Client> putClientResponse(Client client);

    ResponseEntity<Client> patchClientResponse(Long id, List<Authority> authorities);

    ResponseEntity<Void> deleteAllClientResponse();
}
