package com.example.demo.user.service;

import com.example.demo.user.entity.Cart;
import com.example.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
