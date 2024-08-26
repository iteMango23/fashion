package com.sample.fashion.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoryPriceDto {
    private final String category;
    private final double price;
}
