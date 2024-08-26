package com.sample.fashion.model;

import com.sample.fashion.model.dto.PriceListDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class CategoryPriceResponse {
    private final String category;
    private final List<PriceListDto> lowestPrices;
    private final List<PriceListDto> highestPrices;
}
