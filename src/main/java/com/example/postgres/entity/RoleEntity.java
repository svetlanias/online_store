package com.example.postgres.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "access_level", nullable = false)
    private RoleType accessLevel;
}
