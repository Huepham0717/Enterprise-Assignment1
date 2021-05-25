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

package com.example.demo.user.repository;

import com.example.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Repository
@Transactional(readOnly= true)
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT s FROM User s where s.email =?1")
    Optional<User> findUsersByEmail(String email);
    @Query("SELECT s FROM User s where s.userName =?1")
    Optional<User> findUsersByUserName(String userName);
    @Query("SELECT s FROM User s where s.id =?1")
    User findUsersByUserId(Long id);
    @Transactional
    @Modifying
    @Query("UPDATE User u "+"SET u.enabled = TRUE WHERE u.userName =?1 ")
    int enableUser(String userName);
}
