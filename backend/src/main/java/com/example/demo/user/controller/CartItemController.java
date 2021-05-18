package com.example.demo.user.controller;

import com.example.demo.user.entity.Cart;
import com.example.demo.user.entity.CartItem;
import com.example.demo.user.service.CartItemService;
import com.example.demo.user.service.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/cartItem")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }
    @PostMapping
    public void addNewCartItem(@RequestBody CartItem cartItem){
        cartItemService.addNewCartItem(cartItem);
    }
    @GetMapping(path="{id}")
    public List<CartItem> showCart(@PathVariable("id") Long id){
        return cartItemService.listCartItems(id);
    }
    @PostMapping(path = "/add/{cid}/{pid}/{qty}")
    public String addProductToCart(@PathVariable("cid") Long id,
                                   @PathVariable("pid") Long productId,
                                   @PathVariable("qty") Integer quantity){
        Cart cart = cartRepository.findCartById(id);
        Integer addQuantity = cartItemService.addQuantityProduct(productId,cart,quantity);
        return addQuantity + " products is added";
    }
    @PostMapping(path = "/remove/{cid}/{pid}/{qty}")
    public String removeProductToCart(@PathVariable("cid") Long id,
                                   @PathVariable("pid") Long productId,
                                   @PathVariable("qty") Integer quantity){
        Cart cart = cartRepository.findCartById(id);
        Integer addQuantity = cartItemService.removeQuantityProduct(productId,cart,quantity);
        return addQuantity + " products is remove";
    }
    @PostMapping(path = "/remove/{cid}/{pid}")
    public String removeProductFromCart(@PathVariable("cid") Long id,
                                        @PathVariable("pid") Long productId){
        cartItemService.removeProduct(productId,id);
        return "The product has been delete";
    }
}
