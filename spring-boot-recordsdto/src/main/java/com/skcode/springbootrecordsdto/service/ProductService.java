package com.skcode.springbootrecordsdto.service;

import com.skcode.springbootrecordsdto.dto.ProductRequestDTO;
import com.skcode.springbootrecordsdto.dto.ProductResponseDTO;
import com.skcode.springbootrecordsdto.entity.Product;
import com.skcode.springbootrecordsdto.mapper.ProductMapper;
import com.skcode.springbootrecordsdto.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.IO.println;

@Service
public class ProductService {

    private final ProductRepository productRepo;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        Product product = productMapper.toEntity(dto);
        Product savedProduct = productRepo.save(product);
        return productMapper.toDto(savedProduct);
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepo.findAll().stream().map(productMapper::toDto).toList();
    }

    public ProductResponseDTO getProductById(Long id) {
       Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
       return productMapper.toDto(product);
    }

}
