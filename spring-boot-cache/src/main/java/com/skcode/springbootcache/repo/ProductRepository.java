package com.skcode.springbootcache.repo;

import com.skcode.springbootcache.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
