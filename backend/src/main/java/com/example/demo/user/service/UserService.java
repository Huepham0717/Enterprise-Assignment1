package com.example.demo.user.service;

import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserRepository;
import com.example.demo.user.entity.token.ConfirmationToken;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.util.Collections.singletonList;
import java.util.*;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user){
        Optional<User> userOptional = userRepository.findUsersByEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException(
                    "User with id "+userId+" does not exists"
            );
        }
        userRepository.deleteById(userId);
    }
    @ Transactional
    public void updateUser(Long userId, String firstName,
                           String userName, String lastName,
                           LocalDate birthDay, String address,
                           String email){
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalStateException(
                "User with id "+userId+" does not exists"
        ));
        if(firstName != null && firstName.length() > 0
                && !Objects.equals(user.getFirstName(),firstName )){
            user.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() > 0
                && !Objects.equals(user.getLastName(),lastName)){
            user.setLastName(lastName);
        }
        if (birthDay != null && !Objects.equals(user.getBirthDay(),birthDay)){
            user.setBirthDay(birthDay);
        }
        if (address != null && address.length() > 0
                && !Objects.equals(user.getAddress(),address)){
            user.setAddress(address);
        }
        if (email != null && email.length() > 0
                && !Objects.equals(user.getEmail(),email)){
            Optional<User> userOptional = userRepository.findUsersByEmail(email);
            if(userOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            user.setEmail(email);
        }
        if (userName != null && userName.length() > 0
                && !Objects.equals(user.getUserName(),userName)){
            Optional<User> userOptional = userRepository.findUsersByUserName(userName);
            if(userOptional.isPresent()){
                throw new IllegalStateException("user name taken");
            }
            user.setUserName(userName);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findUsersByUserName(userName);

        User user = userOptional
                .orElseThrow(()->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,userName)));

        return new org.springframework.security
                .core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true,
                true, getAuthorities("USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return singletonList(new SimpleGrantedAuthority(role));
    }
    public String signUpUser(User user){
        boolean userExists=userRepository.findUsersByEmail(user.getEmail()).isPresent();
        boolean userExists1=userRepository.findUsersByUserName(user.getUserName()).isPresent();
        if (userExists && userExists1){
            throw new IllegalStateException("email already taken");
        }
        String encodePassword= bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userRepository.save(user);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
    public int enableUser(String userName){
        return userRepository.enableUser(userName);
    }
}
