package com.example.demo.user.controller;

import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin
@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping
//    public List<User> getUsers(){
//        return userService.getUsers();
//    }

    @GetMapping(path = "{userName}")
    public UserDetails loadUserByUsername(@PathVariable("userName") String userName) {
        return userService.loadUserByUsername(userName);
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
    @PutMapping(path="{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) LocalDate birthDay,
            @RequestParam(required = false) Long phoneNumber,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String email){
        userService.updateUser(userId,firstName,userName,lastName,birthDay,phoneNumber,address,email);

    }
}
