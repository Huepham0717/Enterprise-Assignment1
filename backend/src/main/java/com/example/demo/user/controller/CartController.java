package com.example.demo.user.controller;

import com.example.demo.user.entity.Cart;
import com.example.demo.user.entity.CartItem;
import com.example.demo.user.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping
    public void addNewCart(@RequestBody Cart cart){
        cartService.addNewCart(cart);
    }
    // GET "localhost:8080/cart/1"
    @GetMapping(path="{id}")
    public Cart showCart(@PathVariable("id") Long id){
        return cartService.showCart(id);
    }
    // GET "localhost:8080/cart/user/1"
    @GetMapping(path="user/{userId}")
    public List<Cart> listCart(@PathVariable("userId") Long id){
        return cartService.listCart(id);
    }
    @PutMapping(path = "{cartId}")
    public String updateAmountInTheCart(@PathVariable("cartId") Long cartId,
                                        @RequestParam(required = false) float amount){
        return cartService.updateAmountInTheCart(cartId,amount);
    }
}
