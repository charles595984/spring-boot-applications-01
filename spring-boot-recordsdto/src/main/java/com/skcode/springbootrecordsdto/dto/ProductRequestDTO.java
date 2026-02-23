package com.skcode.springbootrecordsdto.dto;

public record ProductRequestDTO(
        Long id,
        String name,
        Double price
) {
}
