package com.example.birdscout.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "birdTable")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long birdId;

    @Column(nullable = false)
    private String birdName;

    private String birdDescription;
}
