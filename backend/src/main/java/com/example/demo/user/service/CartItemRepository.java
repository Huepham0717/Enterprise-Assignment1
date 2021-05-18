package com.example.demo.user.service;

import com.example.demo.user.entity.Cart;
import com.example.demo.user.entity.CartItem;
import com.example.demo.user.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    @Query("SELECT c FROM CartItem c where c.cart =?1")
    List<CartItem> findCartItemBytByCart(Cart cart);
    @Query("SELECT c FROM CartItem c WHERE c.cart = ?1 and c.product = ?2")
    CartItem findByCartAndProduct(Cart cart, Product product);
    @Query("DELETE FROM CartItem c WHERE c.cart.cartId = ?1 and c.product.productId = ?2")
    @Modifying
    public void deleteByCartItemIdAndProduct(Long id, Long productId);
}
