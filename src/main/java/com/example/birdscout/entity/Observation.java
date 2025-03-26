package com.example.birdscout.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "observationTable")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long observationId;

    @ManyToOne
    @JoinColumn(name = "birdId")
    private Bird bird;

    @ManyToOne
    @JoinColumn(name = "observerId")
    private User observer;

    private String location;  // location name or coordinates
    private LocalDateTime dateTime;  // date and time of observation
}
