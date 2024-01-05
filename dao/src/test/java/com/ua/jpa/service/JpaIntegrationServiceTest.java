package com.ua.jpa.service;

import com.ua.jpa.dao.ClientRepository;
import com.ua.jpa.model.Authority;
import com.ua.jpa.model.Client;
import com.ua.jpa.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class JpaIntegrationServiceTest {
    @Mock
    private ClientRepository repository = Mockito.mock(ClientRepository.class);
    private JpaIntegrationService service;
    private Role role;
    private String type;
    private final Long clientId = 1L;
    private final Client client = new Client();

    @BeforeEach
    public void setUp() {
        type = "USER";
        role = new Role(type);
        client.setRole(role);
        client.setId(clientId);
        service = new JpaIntegrationService(repository);
    }

    @Test
    void testGetClientResponse() {
        when(repository.getByClientIdAndType(clientId, type)).thenReturn(client);
        ResponseEntity<Client> response = service.getClientResponse(clientId, type);
        assertEquals(ResponseEntity.ok(client), response);
        verify(repository, times(1)).getByClientIdAndType(clientId, type);
    }

    @Test
    void testGetClientsResponseByRole() {
        List<Client> expectedClients = Collections.singletonList(client);
        when(repository.findByRolesIn(role)).thenReturn(expectedClients);
        var response = service.getClientsResponseByRole(role);
        assertEquals(ResponseEntity.ok(expectedClients), response);
        verify(repository, times(1)).findByRolesIn(role);
    }

    @Test
    void testGetAll() {
        List<Client> clients = Collections.singletonList(client);
        when(repository.findAllWithRoleAndAuthorities()).thenReturn(clients);
        ResponseEntity<List<Client>> response = service.getAll();
        assertEquals(ResponseEntity.ok(clients), response);
        verify(repository, times(1)).findAllWithRoleAndAuthorities();
    }

    @Test
    void testPostClientResponse() {
        when(repository.save(client)).thenReturn(client);
        ResponseEntity<Client> response = service.postClientResponse(client);
        assertEquals(ResponseEntity.ok(client), response);
        verify(repository, times(1)).save(client);
    }

    @Test
    void testPostClientResponseList() {
        List<Client> clientsToSave = Collections.singletonList(client);
        when(repository.saveAll(clientsToSave)).thenReturn(clientsToSave);
        var response = service.postClientResponse(clientsToSave);
        assertEquals(ResponseEntity.ok(clientsToSave), response);
        verify(repository, times(1)).saveAll(clientsToSave);
    }

    @Test
    void testPutClientResponse() {
        Client clientToUpdate = new Client();
        when(repository.save(clientToUpdate)).thenReturn(clientToUpdate);
        var response = service.putClientResponse(clientToUpdate);
        assertEquals(ResponseEntity.ok(clientToUpdate), response);
        verify(repository, times(1)).save(clientToUpdate);
    }

    @Test
    void testPatchClientResponse() {
        List<Authority> authorities = Collections.singletonList(new Authority());
        when(repository.findById(clientId)).thenReturn(Optional.of(client));
        when(repository.save(client)).thenReturn(client);
        var response = service.patchClientResponse(clientId, authorities);
        assertEquals(ResponseEntity.ok(client), response);
        verify(repository, times(1)).findById(clientId);
        verify(repository, times(1)).save(client);
    }

    @Test
    void testDeleteAllClientResponse() {
        ResponseEntity<Void> response = service.deleteAllClientResponse();
        assertEquals(ResponseEntity.noContent().build(), response);
        verify(repository, times(1)).deleteAll();
    }
}
