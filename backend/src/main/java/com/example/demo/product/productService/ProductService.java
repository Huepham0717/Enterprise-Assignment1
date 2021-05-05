package com.example.demo.product.productService;

import com.example.demo.product.productEntity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public List<Product> getProducts() {
        return List.of(
                new Product(
                        1L,
                        "iPhone 12",
                        "Apple",
                        999.99F,
                        "12 months",
                        100L,
                        "issa phone",
                        "issa image of an iPhone",
                        true
                )
        );
    }
}
