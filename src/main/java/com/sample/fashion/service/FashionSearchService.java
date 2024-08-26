package com.sample.fashion.service;

import com.sample.fashion.model.BrandCategoryPriceResponse;
import com.sample.fashion.model.CategoryPriceResponse;
import com.sample.fashion.model.FashionResponse;
import com.sample.fashion.model.dto.CategoryPriceDto;
import com.sample.fashion.model.dto.FashionDto;
import com.sample.fashion.model.dto.PriceListDto;
import com.sample.fashion.model.entity.Fashion;
import com.sample.fashion.repository.FashionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FashionSearchService {

    @Autowired
    private FashionRepository fashionRepository;

    public FashionResponse getLowestPricesGroupByCategory() {
        List<Fashion> allList = fashionRepository.findAll();

        // 카테고리별 최저 가격을 저장할 Map
        Map<String, FashionDto> lowestPriceMap = new HashMap<>();
        // 최저가 총합을 저장할 double 변수
        double totalSum;

        for (Fashion fashion : allList) {
            String category = fashion.getCategory();
            String brandName = fashion.getBrandName();
            double price = fashion.getPrice();
            lowestPriceMap.compute(category, (key, existing) -> {
                if (existing == null || price < existing.getPrice()) {
                    return new FashionDto(category, brandName, price);
                }
                return existing;
            });
        }

        // 총합 계산
        totalSum = lowestPriceMap.values().stream().mapToDouble(FashionDto::getPrice).sum();

        // 결과 DTO 생성
        List<FashionDto> fashionPrices = lowestPriceMap.values().stream().collect(Collectors.toList());
        return new FashionResponse(fashionPrices, totalSum);
    }

    public BrandCategoryPriceResponse getCheapestBrand() {
        List<Fashion> allList = fashionRepository.findAll();

        // 브랜드별 카테고리 가격을 저장할 Map
        Map<String, Map<String, Double>> brandCategoryPrices = new HashMap<>();

        for (Fashion fashion : allList) {
            String brandName = fashion.getBrandName();
            String category = fashion.getCategory();
            double price = fashion.getPrice();
            brandCategoryPrices
                    .computeIfAbsent(brandName, k -> new HashMap<>())
                    .put(category, price);
        }

        // 브랜드별 총액 계산
        Map<String, Double> breandTotalSums = brandCategoryPrices.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().values().stream().mapToDouble(Double::doubleValue).sum()
                ));

        // 가장 저렴한 브랜드 찾기
        String cheapestBrand = Collections.min(breandTotalSums.entrySet(), Map.Entry.comparingByValue()).getKey();
        double totalSum = breandTotalSums.get(cheapestBrand);

        // 결과 DTO 생성
        List<CategoryPriceDto> categoryPrices = brandCategoryPrices.get(cheapestBrand).entrySet().stream()
                .map(entry -> new CategoryPriceDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return new BrandCategoryPriceResponse(cheapestBrand, categoryPrices, totalSum);
    }

    public CategoryPriceResponse getPriceRange(String category) {
        List<Fashion> allList = fashionRepository.findByCategory(category);
        if (allList.isEmpty()) {
            return new CategoryPriceResponse(category, Collections.emptyList(), Collections.emptyList());
        }

        // 최저가와 최고가 계산
        Map<String, Double> brandPrices = allList.stream()
                .collect(Collectors.toMap(
                        Fashion::getBrandName,
                        Fashion::getPrice
                ));

        double minPrice = Collections.min(brandPrices.values());
        double maxPrice = Collections.max(brandPrices.values());

        List<PriceListDto> lowestPrices = brandPrices.entrySet().stream()
                .filter(entry -> entry.getValue() == minPrice)
                .map(entry -> new PriceListDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        List<PriceListDto> highestPrices = brandPrices.entrySet().stream()
                .filter(entry -> entry.getValue() == maxPrice)
                .map(entry -> new PriceListDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return new CategoryPriceResponse(category, lowestPrices, highestPrices);
    }

}
