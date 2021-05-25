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
import com.example.demo.user.service.CartItemService;
import com.example.demo.user.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// this class serves as a "router" for incoming HTTP requests.
// it also defines the REST APIs of the backend.
@CrossOrigin
@RestController
@RequestMapping(path = "/cartItem")
public class CartItemController {

    // Connecting with CartItemService.java
    @Autowired
    private CartItemService cartItemService;

    // Connecting with CartRepository.java
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    // add new product to cart
    @PostMapping
    public void addNewCartItem(@RequestBody CartItem cartItem){
        cartItemService.addNewCartItem(cartItem);
    }

    // load everything in CartItem by cartId
    @GetMapping(path="{id}")
    public List<CartItem> showCartItem(@PathVariable("id") Long id){
        return cartItemService.listCartItems(id);
    }

    // modify a product that is already in cart
    @PostMapping(path = "/add/{cid}/{pid}/{qty}")
    public String addProductToCart(@PathVariable("cid") Long id,
                                   @PathVariable("pid") Long productId,
                                   @PathVariable("qty") Integer quantity){
        Cart cart = cartRepository.findCartById(id);
        Integer addQuantity = cartItemService.addQuantityProduct(productId,cart,quantity);
        return addQuantity + " products currently in this cart.";
    }
    @PostMapping(path = "/remove/{cid}/{pid}/{qty}")
    public String removeProductToCart(@PathVariable("cid") Long id,
                                   @PathVariable("pid") Long productId,
                                   @PathVariable("qty") Integer quantity){
        Cart cart = cartRepository.findCartById(id);
        Integer addQuantity = cartItemService.removeQuantityProduct(productId,cart,quantity);
        return addQuantity + " products currently in this cart.";
    }
    @PostMapping(path = "/remove/{cid}/{pid}")
    public String removeProductFromCart(@PathVariable("cid") Long id,
                                        @PathVariable("pid") Long productId){
        cartItemService.removeProduct(productId,id);
        return "This product has been removed from cart.";
    }
}
