package com.example.demo.user.config;

import com.example.demo.user.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner productCommandLineRunner(ProductRepository repository){
        return args -> {

        };
    }
}
