package com.sample.fashion.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PriceListDto {
    private final String brandName;
    private final double price;
}
