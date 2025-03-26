package com.example.birdscout.repository;

import com.example.birdscout.entity.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdRepository extends JpaRepository<Bird, Long> {
}
