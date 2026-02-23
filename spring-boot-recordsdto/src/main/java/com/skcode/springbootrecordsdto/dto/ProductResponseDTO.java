package com.skcode.springbootrecordsdto.dto;

public record ProductResponseDTO(
        Long id,
        String name,
        Double price
) {
}
