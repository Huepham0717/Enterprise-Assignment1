package com.example.demo.user.controller;

import com.example.demo.user.entity.Product;
import com.example.demo.user.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "search")
    public List<Product> searchProduct(@RequestParam("keyword") String keyword){
        return productService.searchProduct(keyword);
    }

    @PostMapping
    public void addNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
       productService.deleteProduct( productId);
    }

    @GetMapping(path = "{productName}")
    public Optional<Product> loadProductByProductName(@PathVariable("productName") String productName) {
        return productService.loadProductByProductName(productName);
    }

}
