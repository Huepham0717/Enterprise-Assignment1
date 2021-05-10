package com.example.demo.user.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
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
