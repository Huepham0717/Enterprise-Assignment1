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
                    "Phone",
                    "12 Months",
                    100L,
                    "issa iPhone 12 Pro Max 128GB Unlocked",
                    "issa photo of an iPhone 12 Pro Max 128GB Unlocked",
                    1099.00F,
                    0.5F
            );

            Product iPhone12ProMax256GBUnlocked = new Product(
                    "iPhone 12 Pro Max 256GB Unlocked",
                    "Apple",
                    "Phone",
                    "12 Months",
                    100L,
                    "issa iPhone 12 Pro Max 256GB Unlocked",
                    "issa photo of an iPhone 12 Pro Max 256GB Unlocked",
                    1199.00F,
                    0.5F
            );

            Product iPhone12ProMax512GBUnlocked = new Product(
                    "iPhone 12 Pro Max 512GB Unlocked",
                    "Apple",
                    "Phone",
                    "12 Months",
                    100L,
                    "issa iPhone 12 Pro Max 512GB Unlocked",
                    "issa photo of an iPhone 12 Pro Max 512GB Unlocked",
                    1399.00F,
                    0.5F
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
