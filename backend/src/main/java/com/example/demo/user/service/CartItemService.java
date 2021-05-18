package com.example.demo.user.service;

import com.example.demo.user.entity.Cart;
import com.example.demo.user.entity.CartItem;
import com.example.demo.user.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    public void addNewCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }
    public List<CartItem> listCartItems(Long id){
        Cart cart = cartRepository.findCartById(id);
        System.out.println("listCartItems");
        return cartItemRepository.findCartItemBytByCart(cart);
    }
    public Integer addQuantityProduct(Long productId, Cart cart, Integer quantity){
        Product product = productRepository.findProductByProductId(productId).get();
        CartItem cartItem = cartItemRepository.findByCartAndProduct(cart,product);
        Integer addQuantity= quantity;
        float totalAmount = cartItem.getAmount();
        if (cartItem != null){
            addQuantity = cartItem.getQuantity() + quantity;
            cartItem.setQuantity(addQuantity);
            totalAmount = cartItem.getAmount() * addQuantity;
            cartItem.setAmount(totalAmount);
        } else {
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setAmount(totalAmount);
            cartItem.setCart(cart);
            cartItem.setProduct(product);
        }
        cartItemRepository.save(cartItem);
        return addQuantity;
    }
    public Integer removeQuantityProduct(Long productId, Cart cart, Integer quantity){
        Product product = productRepository.findProductByProductId(productId).get();
        CartItem cartItem = cartItemRepository.findByCartAndProduct(cart,product);
        Integer addQuantity= quantity;
        float totalAmount = cartItem.getAmount();
        if (cartItem != null){
            addQuantity = cartItem.getQuantity() - quantity;
            cartItem.setQuantity(addQuantity);
            totalAmount = cartItem.getAmount() * addQuantity;
            cartItem.setAmount(totalAmount);
        } else {
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setAmount(totalAmount);
            cartItem.setCart(cart);
            cartItem.setProduct(product);
        }
        cartItemRepository.save(cartItem);
        return addQuantity;
    }
    public void removeProduct(Long productId, Long id){
        cartItemRepository.deleteByCartItemIdAndProduct(id,productId);
    }
}

