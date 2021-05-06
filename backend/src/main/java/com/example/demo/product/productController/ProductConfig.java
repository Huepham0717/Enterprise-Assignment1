package com.example.demo.product.productController;

import com.example.demo.product.productEntity.Product;
import com.example.demo.product.productService.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner productCommandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product iPhone12ProMax128GBUnlocked = new Product(
                    "iPhone 12 Pro Max 128GB Unlocked",
                    "Apple",
                    1099.00F,
                    1F,
                    1099.00F,
                    "12 Months",
                    100L,
                    "issa iPhone 12 Pro Max 128GB Unlocked",
                    "issa photo of an iPhone 12 Pro Max 128GB Unlocked"
            );

            Product iPhone12ProMax256GBUnlocked = new Product(
                    "iPhone 12 Pro Max 256GB Unlocked",
                    "Apple",
                    1199.00F,
                    1F,
                    1199.00F,
                    "12 Months",
                    100L,
                    "issa iPhone 12 Pro Max 256GB Unlocked",
                    "issa photo of an iPhone 12 Pro Max 256GB Unlocked"
            );

            Product iPhone12ProMax512GBUnlocked = new Product(
                    "iPhone 12 Pro Max 512GB Unlocked",
                    "Apple",
                    1399.00F,
                    1F,
                    1399.00F,
                    "12 Months",
                    100L,
                    "issa iPhone 12 Pro Max 512GB Unlocked",
                    "issa photo of an iPhone 12 Pro Max 512GB Unlocked"
            );

            productRepository.saveAll(
                    List.of(
                            iPhone12ProMax128GBUnlocked,
                            iPhone12ProMax256GBUnlocked,
                            iPhone12ProMax512GBUnlocked
                    )
            );
        };
    }
}
