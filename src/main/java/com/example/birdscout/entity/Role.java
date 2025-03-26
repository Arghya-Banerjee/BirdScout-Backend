package com.example.birdscout.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roleTable")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false, unique = true)
    private String roleName;  // e.g. "ROLE_USER", "ROLE_ADMIN"
}
