package com.example.demo.user.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final LocalDate birthDay;
    private final Long phoneNumber;
    private final String password;
    private final String address;
    private final String email;
}
