package com.sample.fashion.model;

import com.sample.fashion.model.dto.FashionDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class FashionResponse {
    private final List<FashionDto> categoryPrices;
    private final double totalSum;
}
