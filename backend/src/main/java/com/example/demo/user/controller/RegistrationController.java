package com.example.demo.user.controller;

import com.example.demo.user.entity.RegistrationRequest;
import com.example.demo.user.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping(path ="confirm")
    public String confirm(@RequestParam("token")String token){
        return registrationService.confirmToken(token);
    }
}
