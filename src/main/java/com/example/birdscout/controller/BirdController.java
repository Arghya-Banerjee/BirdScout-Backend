package com.example.birdscout.controller;

import com.example.birdscout.entity.Bird;
import com.example.birdscout.repository.BirdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/birds")
@RequiredArgsConstructor
public class BirdController {

    private final BirdRepository birdRepository;

    @GetMapping
    public List<Bird> getAllBirds() {
        return birdRepository.findAll();
    }

    @PostMapping
    public Bird createBird(@RequestBody Bird bird) {
        return birdRepository.save(bird);
    }

    @GetMapping("/{id}")
    public Bird getBirdById(@PathVariable Long id) {
        return birdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bird not found with id " + id));
    }

    @PutMapping("/{id}")
    public Bird updateBird(@PathVariable Long id, @RequestBody Bird birdRequest) {
        Bird existingBird = birdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bird not found with id " + id));
        existingBird.setBirdName(birdRequest.getBirdName());
        existingBird.setBirdDescription(birdRequest.getBirdDescription());
        return birdRepository.save(existingBird);
    }

    @DeleteMapping("/{id}")
    public void deleteBird(@PathVariable Long id) {
        birdRepository.deleteById(id);
    }
}
