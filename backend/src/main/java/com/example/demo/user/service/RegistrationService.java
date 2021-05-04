package com.example.demo.user.service;

import com.example.demo.user.entity.RegistrationRequest;
import com.example.demo.user.entity.User;
import com.example.demo.user.entity.UserRole;
import com.example.demo.user.entity.token.ConfirmationToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return userService.signUpUser(new User(
                request.getFirstName(),
                request.getLastName(),
                request.getUserName(),
                request.getPassword(),
                request.getBirthDay(),
                request.getAddress(),
                request.getEmail(),
                UserRole.USER
        ));
    }

    @Transactional
    public String confirmToken(String token){
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
                .orElseThrow(()-> new IllegalStateException("token not found"));
        if (confirmationToken.getConfirmedTime()!= null){
            throw new IllegalStateException("email already confirmed");
        }
        LocalDateTime expiredTime = confirmationToken.getExpiredTime();
        if (expiredTime.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token expired");
        }
        confirmationTokenService.setConfirmedTime(token);
        userService.enableUser(confirmationToken.getUser().getUserName());
        return "confirmed";
    }
}
