package com.ua.jpa.service;

import com.ua.jpa.dao.ClientRepository;
import com.ua.jpa.model.Authority;
import com.ua.jpa.model.Client;
import com.ua.jpa.model.Role;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaIntegrationService implements IntegrationService {

    private final ClientRepository repository;

    public JpaIntegrationService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Client> getClientResponse(Long clientId, String type) {
        Client client = repository.getByClientIdAndType(clientId, type);
        return client != null
               ? ResponseEntity.ok(client)
               : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<Client>> getClientsResponseByRole(Role role) {
        List<Client> clients = repository.findByRolesIn(role);
        return !clients.isEmpty()
               ? ResponseEntity.ok(clients)
               : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok(repository.findAllWithRoleAndAuthorities());
    }

    @Override
    public ResponseEntity<Client> postClientResponse(Client client) {
        return ResponseEntity.ok(repository.save(client));
    }

    @Override
    public ResponseEntity<List<Client>> postClientResponse(List<Client> clients) {
        return ResponseEntity.ok(repository.saveAll(clients));
    }

    @Override
    public ResponseEntity<Client> putClientResponse(Client client) {
        return ResponseEntity.ok(repository.save(client));
    }

    @Override
    public ResponseEntity<Client> patchClientResponse(Long id, List<Authority> authorities) {
        Client client = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Client not found with id: " + id));
        client.addAuthorities(authorities);
        return ResponseEntity.ok(repository.save(client));
    }

    @Override
    public ResponseEntity<Void> deleteAllClientResponse() {
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
