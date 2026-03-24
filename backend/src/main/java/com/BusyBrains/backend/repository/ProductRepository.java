package com.BusyBrains.backend.repository;

import com.BusyBrains.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}