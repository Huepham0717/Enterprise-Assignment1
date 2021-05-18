package com.example.demo.user.service;


import com.example.demo.user.entity.Cart;
import com.example.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly= true)
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query("SELECT c FROM Cart c where c.cartId =?1")
    Cart findCartById(Long id);
    @Query("SELECT c FROM Cart c where c.user =?1")
    List<Cart> findCartByUser(User user);
}
