package com.example.demo.product.productService;

import com.example.demo.product.productEntity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT s FROM Product s WHERE s.productName = ?1")
    Optional<Product> findProductByName(String productName);

    @Query("SELECT s FROM Product s WHERE s.productBrand = ?1")
    Optional<Product> findProductByBrand(String productBrand);

    @Query("SELECT s FROM Product s WHERE s.productType = ?1")
    Optional<Product> findProductByType(String productType);
}
