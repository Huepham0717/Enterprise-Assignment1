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

package com.example.demo.user.controller;

import com.example.demo.user.entity.Product;
import com.example.demo.user.repository.ProductRepository;
import com.example.demo.user.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// this class serves as a "router" for incoming HTTP requests.
// it also defines the REST APIs of the backend.
@CrossOrigin
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    // connecting with ProductService.java
    @Autowired
    private final ProductService productService;

    // connecting with ProductRepository.java
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    // Search for all products using a keyword.
    // Very powerful. If you need to search for any products containing any string anywhere in its data, you use this.
    @GetMapping(path = "search")
    public List<Product> searchProduct(@RequestParam("keyword") String keyword){
        return productService.searchProduct(keyword.toLowerCase());
    }

    @PostMapping
    public void addNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
       productService.deleteProduct( productId);
    }

    @GetMapping(path = "name/{productName}")
    public Optional<Product> loadProductByProductName(@PathVariable("productName") String productName) {
        return productService.loadProductByProductName(productName);
    }

    @GetMapping(path = "id/{productId}")
    public Optional<Product> loadProductByProductId(@PathVariable("productId") Long productId) {
        return productService.loadProductByProductId(productId);
    }

    @GetMapping(path ="sort")
    public List<Product> sortProductByASC(@RequestParam("price") String price){
        if (price.equals("ASC")) {
            return productRepository.findAllByOrderByPriceAsc();
        } else if (price.equals("DESC")){
            return productRepository.findAllByOrderByPriceDesc();
        }
        return productRepository.findAll();
    }
}
