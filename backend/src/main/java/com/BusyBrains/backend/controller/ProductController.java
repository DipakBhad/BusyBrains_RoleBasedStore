package com.BusyBrains.backend.controller;


import com.BusyBrains.backend.entity.Product;
import com.BusyBrains.backend.repository.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // GET ALL PRODUCTS
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }



    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productRepository.save(product);
    }


    // ADD PRODUCT

    @PostMapping
    public Product addProduct(@RequestBody Product product, HttpServletRequest request) {

        String role = (String) request.getAttribute("role");

        if (!"ADMIN".equals(role)) {
            throw new RuntimeException("Access Denied");
        }

        return productRepository.save(product);
    }

    // DELETE PRODUCT

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id, HttpServletRequest request) {

        String role = (String) request.getAttribute("role");

        if (!"ADMIN".equals(role)) {
            throw new RuntimeException("Access Denied");
        }

        productRepository.deleteById(id);
        return "Deleted";
    }


}