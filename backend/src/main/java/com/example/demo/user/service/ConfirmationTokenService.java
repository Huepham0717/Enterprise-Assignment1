package com.example.demo.user.service;

import com.example.demo.user.entity.token.ConfirmationToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){

        confirmationTokenRepository.save(token);
    }

    public Optional <ConfirmationToken> getToken(String token){
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedTime(String token){
        return confirmationTokenRepository.updateConfirmedTime(token, LocalDateTime.now());
    }
}
