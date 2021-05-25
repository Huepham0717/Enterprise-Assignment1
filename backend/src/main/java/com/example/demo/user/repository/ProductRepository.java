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

import com.example.demo.user.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly= true)
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p where lower(p.productName) LIKE %?1%")
    Optional<Product> findProductByProductName(String productName);

    @Query("SELECT p FROM Product p where p.productId = ?1")
    Optional<Product> findProductByProductId(Long productId);

    @Query("SELECT p FROM Product p WHERE lower(CONCAT(p.productName, ' ', p.brand, ' ', p.type, ' ', p.price)) LIKE %?1%")
    List<Product> search(String keyword);

    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
}
