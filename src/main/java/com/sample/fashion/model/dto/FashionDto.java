package com.sample.fashion.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FashionDto {
    private final String brandName;
    private final String category;
    private final double price;
}
