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
