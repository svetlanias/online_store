package com.example.postgres.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
public class CreateUserRequest {
    private Long roleId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String passwordHash;
}
