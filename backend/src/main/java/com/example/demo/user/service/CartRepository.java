package com.example.demo.user.service;

import com.example.demo.user.entity.Cart;
import com.example.demo.user.entity.Product;
import com.example.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query("SELECT c FROM Cart c where c.user =?1")
    List<Cart> findCartByUser(User user);
    @Query("SELECT c FROM Cart c WHERE c.user = ?1 and c.product = ?2")
    Cart findByUserAndProduct( User user, Product product);
    @Query("DELETE FROM Cart c WHERE c.user.id = ?1 and c.product.productId = ?2")
    @Modifying
    public void deleteByUserAndProduct(Long id, Long productId);
}
