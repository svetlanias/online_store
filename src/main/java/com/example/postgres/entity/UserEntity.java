package com.example.postgres.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "INT GENERATED ALWAYS AS IDENTITY")
    protected Long userId;

    @Column(name = "roles_id", nullable = false)
    protected Long roleId;

    @Column(name = "first_name", nullable = false, length = 50)
    protected String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    protected String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    protected String email;

    @Column(name = "phone", nullable = false, unique = true, length = 10)
    protected String phone;

    @Column(name = "password_hash", nullable = false, length = 255)
    protected String passwordHash;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    protected LocalDateTime createdAt;
}