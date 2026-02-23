package com.skcode.springbootrecordsdto.mapper;

import com.skcode.springbootrecordsdto.dto.ProductRequestDTO;
import com.skcode.springbootrecordsdto.dto.ProductResponseDTO;
import com.skcode.springbootrecordsdto.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductRequestDTO dto);

    ProductResponseDTO toDto(Product product);

}
