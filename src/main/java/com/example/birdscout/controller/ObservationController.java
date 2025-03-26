package com.example.birdscout.controller;

import com.example.birdscout.entity.Observation;
import com.example.birdscout.repository.ObservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/observations")
@RequiredArgsConstructor
public class ObservationController {

    private final ObservationRepository observationRepository;

    @GetMapping
    public List<Observation> getAllObservations() {
        return observationRepository.findAll();
    }

    @PostMapping
    public Observation createObservation(@RequestBody Observation observation) {
        return observationRepository.save(observation);
    }

    @GetMapping("/{id}")
    public Observation getObservationById(@PathVariable Long id) {
        return observationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Observation not found: " + id));
    }

    @PutMapping("/{id}")
    public Observation updateObservation(@PathVariable Long id, @RequestBody Observation obsRequest) {
        Observation existingObs = observationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Observation not found: " + id));
        existingObs.setBird(obsRequest.getBird());
        existingObs.setObserver(obsRequest.getObserver());
        existingObs.setLocation(obsRequest.getLocation());
        existingObs.setDateTime(obsRequest.getDateTime());
        return observationRepository.save(existingObs);
    }

    @DeleteMapping("/{id}")
    public void deleteObservation(@PathVariable Long id) {
        observationRepository.deleteById(id);
    }
}
