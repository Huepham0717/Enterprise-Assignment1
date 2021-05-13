package com.example.demo.user.service;

import com.example.demo.user.entity.Cart;
import com.example.demo.user.entity.Product;
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
    @Autowired
    private ProductRepository productRepository;
    public void addNewCart(Cart cart) {
        cartRepository.save(cart);
    }
    public List<Cart> listCartItems(Long id){
        User user = userRepository.findUsersByUserId(id);
        return cartRepository.findCartByUser(user);
    }
    public Integer addQuantityProduct(Long productId, User user, Integer quantity){
        Product product = productRepository.findProductByProductId(productId).get();
        Cart cart = cartRepository.findByUserAndProduct(user,product);
        Integer addQuantity= quantity;
        float totalAmount = cart.getAmount();
        if (cart != null){
            addQuantity = cart.getQuantity() + quantity;
            cart.setQuantity(addQuantity);
            totalAmount = cart.getAmount() * addQuantity;
            cart.setAmount(totalAmount);
        } else {
            cart = new Cart();
            cart.setQuantity(quantity);
            cart.setAmount(totalAmount);
            cart.setUser(user);
            cart.setProduct(product);
        }
        cartRepository.save(cart);
        return addQuantity;
    }
    public Integer removeQuantityProduct(Long productId, User user, Integer quantity){
        Product product = productRepository.findProductByProductId(productId).get();
        Cart cart = cartRepository.findByUserAndProduct(user,product);
        Integer addQuantity= quantity;
        float totalAmount = cart.getAmount();
        if (cart != null){
            addQuantity = cart.getQuantity() - quantity;
            cart.setQuantity(addQuantity);
            totalAmount = cart.getAmount() * addQuantity;
            cart.setAmount(totalAmount);
        } else {
            cart = new Cart();
            cart.setQuantity(quantity);
            cart.setAmount(totalAmount);
            cart.setUser(user);
            cart.setProduct(product);
        }
        cartRepository.save(cart);
        return addQuantity;
    }
    public void removeProduct(Long productId, Long id){
        cartRepository.deleteByUserAndProduct(id,productId);
    }
}

