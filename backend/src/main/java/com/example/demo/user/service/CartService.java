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

package com.example.demo.user.service;

import com.example.demo.user.entity.Cart;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.CartRepository;
import com.example.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    public void addNewCart(Cart cart) {
        cartRepository.save(cart);
    }
    public Cart showCart(Long id){
        System.out.println("showCart");
        return cartRepository.findCartById(id);
    }
    public List<Cart> listCart(Long id){
        User user= userRepository.findUsersByUserId(id);
        System.out.println("listCart");
        return cartRepository.findCartByUser(user);
    }
    @Transactional
    public String updateAmountInTheCart(Long cartId, float amount){
        Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new IllegalStateException(
                "Cart with id "+cartId+" does not exists"
        ));
        if(!Objects.equals(cart.getAmount(),amount)){
            cart.setAmount(amount);
        }
        return "{ \"message\": \"Cart successfully updated.\" }";
    }
}
