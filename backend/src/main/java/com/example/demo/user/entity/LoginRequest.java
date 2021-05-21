package com.example.demo.user.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginRequest {
    private String userName;
    private String password;
}
