package com.skcode.springbootrecordsdto.mapper;

import com.skcode.springbootrecordsdto.dto.ProductRequestDTO;
import com.skcode.springbootrecordsdto.dto.ProductResponseDTO;
import com.skcode.springbootrecordsdto.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-23T16:00:14+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.id() );
        product.setName( dto.name() );
        product.setPrice( dto.price() );

        return product;
    }

    @Override
    public ProductResponseDTO toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Double price = null;

        id = product.getId();
        name = product.getName();
        price = product.getPrice();

        ProductResponseDTO productResponseDTO = new ProductResponseDTO( id, name, price );

        return productResponseDTO;
    }
}
