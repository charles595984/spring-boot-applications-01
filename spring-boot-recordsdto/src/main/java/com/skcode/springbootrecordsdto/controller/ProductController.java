package com.skcode.springbootrecordsdto.controller;

import com.skcode.springbootrecordsdto.dto.ProductRequestDTO;
import com.skcode.springbootrecordsdto.dto.ProductResponseDTO;
import com.skcode.springbootrecordsdto.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static java.lang.IO.println;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ProductResponseDTO create(@RequestBody ProductRequestDTO dto) {
        println("create product method is called");
        return service.createProduct(dto);
    }

    @GetMapping("/getAll")
    public List<ProductResponseDTO> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/getById/{id}")
    public List<ProductResponseDTO> getById(@PathVariable Long id) {
        return Collections.singletonList(service.getProductById(id));
    }

}
