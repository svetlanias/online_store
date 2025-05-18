package com.example.postgres.controller;

import com.example.postgres.dto.request.CreateUserRequest;
import com.example.postgres.dto.response.UserResponse;
import com.example.postgres.entity.UserEntity;
import com.example.postgres.exception.UserNotFoundException;
import com.example.postgres.repository.UserRepository;
import com.example.postgres.routes.UserRoutes;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserApiController {
    private final UserRepository userRepository;

    @GetMapping("/")
    public UserEntity test(){
        UserEntity user=UserEntity.builder()
                .roleId(3L)
                .firstName("test")
                .lastName("dddn")
                .email("defef@efnrg.fejf")
                .phone("3456")
                .passwordHash("dr567ttfgvbhye4dfgvyt655")
                .build();

        user=userRepository.save(user);
        return user;
    }

    @PostMapping(UserRoutes.CREATE)
    public UserResponse create(@RequestBody CreateUserRequest request) {
        UserEntity user=UserEntity.builder()
                .roleId(request.getRoleId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .passwordHash(request.getPasswordHash())
                .build();

        user=userRepository.save(user);
        return UserResponse.of(user);
    }

    @GetMapping(UserRoutes.BY_ID)
    public UserResponse byId(@PathVariable Long id) throws UserNotFoundException {
        return UserResponse.of(userRepository.findById(id).orElseThrow(UserNotFoundException::new)     );
    }

    @GetMapping(UserRoutes.SEARCH)
    public List<UserResponse> search(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return userRepository
                .findAll(pageable)
                .stream()
                .map(UserResponse::of)
                .collect(Collectors.toList());
    }
}
