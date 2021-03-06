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

import com.example.demo.user.entity.Cart;
import com.example.demo.user.entity.CartItem;
import com.example.demo.user.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// this class serves as a "router" for incoming HTTP requests.
// it also defines the REST APIs of the backend.
@CrossOrigin
@RestController
@RequestMapping(path = "/cart")
public class CartController {

    // Connecting with CartService.java
    @Autowired
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // POST requests go here
    @PostMapping
    public void addNewCart(@RequestBody Cart cart){
        cartService.addNewCart(cart);
    }

    // GET requests go here
    // Example: GET "localhost:8080/cart/1"
    @GetMapping(path="{id}")
    public Cart showCart(@PathVariable("id") Long id){
        return cartService.showCart(id);
    }
    // Example: GET "localhost:8080/cart/user/1"
    @GetMapping(path="user/{userId}")
    public List<Cart> listCart(@PathVariable("userId") Long id){
        return cartService.listCart(id);
    }

    // PUT requests go here
    @PutMapping(path = "{cartId}")
    public String updateAmountInTheCart(@PathVariable("cartId") Long cartId,
                                        @RequestParam(required = false) float amount){
        return cartService.updateAmountInTheCart(cartId,amount);
    }
}
