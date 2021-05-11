package com.example.demo.user.service;

import com.example.demo.user.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product){
        Optional<Product> productOptional = productRepository.findProductByProductName(product.getProductName());
        if (productOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        productRepository.save(product);
    }
    public List<Product> searchProduct(String keyword){
        if (keyword!=null){
            return productRepository.search(keyword);
        }
        return productRepository.findAll();
    }
    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException(
                    "Product with id "+productId+" does not exists"
            );
        }
        productRepository.deleteById(productId);
    }
    public Optional<Product> loadProductByProductName(String productName){
        return productRepository.findProductByProductName(productName);
    }
}
