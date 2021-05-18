package com.example.demo.user.controller;

import com.example.demo.user.entity.Cart;
import com.example.demo.user.entity.User;
import com.example.demo.user.service.CartService;
import com.example.demo.user.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping
    public void addNewCart(@RequestBody Cart cart){
        cartService.addNewCart(cart);
    }
    @GetMapping(path="{id}")
    public List<Cart> showCart(@PathVariable("id") Long id){
        return cartService.listCartItems(id);
    }
    @PostMapping(path = "/add/{uid}/{pid}/{qty}")
    public String addProductToCart(@PathVariable("uid") Long id,
                                   @PathVariable("pid") Long productId,
                                   @PathVariable("qty") Integer quantity){
        User user = userRepository.findUsersByUserId(id);
        Integer addQuantity = cartService.addQuantityProduct(productId,user,quantity);
        return addQuantity + " products is added";
    }
    @PostMapping(path = "/remove/{uid}/{pid}/{qty}")
    public String removeProductToCart(@PathVariable("uid") Long id,
                                   @PathVariable("pid") Long productId,
                                   @PathVariable("qty") Integer quantity){
        User user = userRepository.findUsersByUserId(id);
        Integer addQuantity = cartService.removeQuantityProduct(productId,user,quantity);
        return addQuantity + " products is remove";
    }
    @PostMapping(path = "/remove/{uid}/{pid}")
    public String removeProductFromCart(@PathVariable("uid") Long id,
                                        @PathVariable("pid") Long productId){
        cartService.removeProduct(productId,id);
        return "The product has been delete";
    }
}
