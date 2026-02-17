package com.skcode.springbootcache.service;

import com.skcode.springbootcache.dto.ProductDto;
import com.skcode.springbootcache.entity.Product;
import com.skcode.springbootcache.repo.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CachePut(value="PRODUCT_CACHE", key="#result.id")
    public ProductDto createProduct(ProductDto productDto) {
        var product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());

        Product savedProduct = productRepository.save(product);
        return new ProductDto(savedProduct.getId(), savedProduct.getName(), savedProduct.getDescription());
    }

    @Cacheable(value="PRODUCT_CACHE", key="#productId")
    public ProductDto getProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find product with id " + productId));
        return new ProductDto(product.getId(), product.getName(), product.getDescription());
    }

    @CachePut(value="PRODUCT_CACHE", key="#result.id")
    public ProductDto updateProduct(ProductDto productDto) {
        Long productId = productDto.getId();
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find product with id " + productId));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());

        Product updatedProduct = productRepository.save(product);
        return new ProductDto(updatedProduct.getId(), updatedProduct.getName(),
                updatedProduct.getDescription());
    }

    @CacheEvict(value="PRODUCT_CACHE", key="#productId")
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
