//Acknowledgement:
//
//        "Spring Boot Tutorial | Full Course [2021] [NEW]"
//        https://youtu.be/9SGDpanrc8U
//
//        "Java Tutorial - Complete User Login and Registration Backend + Email Verification"
//        https://youtu.be/QwQuro7ekvc
//
//        "Spring Boot Shopping Cart Tutorial with MySQL Database, Thymeleaf, Bootstrap and jQuery"
//        https://youtu.be/rFSxmKen6aQ
//
//        "Build a Full Stack Reddit Clone with – Spring boot and Angular – Part 3"
//        https://programmingtechie.com/2019/11/08/build-a-full-stack-reddit-clone-with-spring-boot-and-angular-part-3/

package com.example.demo.user.controller;

import com.example.demo.user.dto.RegistrationRequest;
import com.example.demo.user.service.RegistrationService;
import lombok.AllArgsConstructor;
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
