package com.example.postgres.dto.response;

import com.example.postgres.entity.UserEntity;
import lombok.Getter;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class UserResponse extends UserEntity {

    public static UserResponse of(UserEntity user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .roleId(user.getRoleId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .passwordHash(user.getPasswordHash())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
