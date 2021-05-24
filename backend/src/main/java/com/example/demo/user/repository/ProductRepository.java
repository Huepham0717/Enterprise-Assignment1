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
