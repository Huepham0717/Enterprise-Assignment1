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

package com.example.demo.user.repository;

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
