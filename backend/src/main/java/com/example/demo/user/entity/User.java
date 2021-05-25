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

package com.example.demo.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

// This class is the template from which Spring Boot will construct a database entity named "users".
// "users" stores all the users in the database.
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "users",uniqueConstraints={@UniqueConstraint(columnNames ={"email", "userName"})})
public class User implements UserDetails {

    // Telling Spring Boot to treat id as the primary key
    // and also auto-generate a unique id for every entry in the table.
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    private Long phoneNumber;
    private String address;
    private String email;

    // either USER or ADMIN
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    // This column stores whether an account has been activated through email or not.
    private Boolean locked = false;
    private Boolean enabled = false;

    public User(String firstName,String lastName
    ,String userName,String password, LocalDate birthDay,Long phoneNumber, String address,String email,UserRole userRole){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.userRole = userRole;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public LocalDate getBirthDay(){
        return birthDay;
    }
    public void setBirthDay(LocalDate birthDay){
        this.birthDay = birthDay;
    }
    public Long getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail (){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    @Override
    public String toString(){
        return "Student{"+
                "id="+id+
                ",firstName='"+firstName+'\''+
                ",lastName='"+lastName+'\''+
                ",userName='"+userName+'\''+
                ",password='"+password+'\''+
                ",birthDay='"+birthDay+'\''+
                ",phoneNumber='"+phoneNumber+'\''+
                ",address='"+address+'\''+
                ",email='"+email+'}';
    }
}
