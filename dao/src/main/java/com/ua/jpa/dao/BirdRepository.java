package com.ua.jpa.dao;

import com.ua.jpa.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BirdRepository
        extends JpaRepository<Bird, Long> {

    List<Bird> findByBird(String birdName);
}
