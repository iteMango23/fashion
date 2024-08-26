package com.sample.fashion.model;

import com.sample.fashion.model.dto.CategoryPriceDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class BrandCategoryPriceResponse {
    final private String brandName;
    final private List<CategoryPriceDto> categoryPrices;
    final private double totalSum;
}
