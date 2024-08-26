package com.sample.fashion.controller;

import com.sample.fashion.model.BrandCategoryPriceResponse;
import com.sample.fashion.model.CategoryPriceResponse;
import com.sample.fashion.model.FashionResponse;
import com.sample.fashion.service.FashionSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fashions/search")
public class FashionSearchController {

    private final FashionSearchService fashionService;

    @Autowired
    public FashionSearchController(FashionSearchService fashionService) {
        this.fashionService = fashionService;
    }

    /**
     * 카테고리별 최저가 브랜드 검색
     *
     * @return 카테고리별 최저가 및 총합 response
     */
    @GetMapping("/category/lowest-price-summary")
    public FashionResponse getLowestPricesGroupByCategory() {
        return fashionService.getLowestPricesGroupByCategory();
    }

    /**
     * 최저가 브랜드 검색
     *
     * @return 최저가 브랜드 정보 및 총합 response
     */
    @GetMapping("/brand/lowest-price-summary")
    public BrandCategoryPriceResponse getCheapestBrand() {
        return fashionService.getCheapestBrand();
    }

    /**
     * 특정 카테고리의 최저가 및 최고가 브랜드 검색
     *
     * @return 특정 카테고리 최저가 및 최고가 브랜드 정보 response
     */
    @GetMapping("/price-range")
    public CategoryPriceResponse getPriceRange(@RequestParam(value = "category") String category) {
        return fashionService.getPriceRange(category);
    }

}

