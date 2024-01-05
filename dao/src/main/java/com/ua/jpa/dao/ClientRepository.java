package com.ua.jpa.dao;

import com.ua.jpa.model.Client;
import com.ua.jpa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c JOIN c.role r WHERE c.id =:clientId AND r.type = :type")
    Client getByClientIdAndType(@Param("clientId") Long clientId, @Param("type") String type);

    @Query("SELECT c FROM Client c WHERE :role MEMBER OF c.authorities")
    List<Client> findByRolesIn(@Param("role") Role role);

    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.role r LEFT JOIN FETCH c.authorities a")
    List<Client> findAllWithRoleAndAuthorities();

    @Query("DELETE FROM Client c WHERE c.name = :name")
    void deleteByName(String name);
}
