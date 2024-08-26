package com.sample.fashion.service;

import com.sample.fashion.model.dto.FashionDto;
import com.sample.fashion.model.entity.Fashion;
import com.sample.fashion.repository.FashionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FashionManagementService {

    @Autowired
    private FashionRepository fashionRepository;

    // save
    public Fashion saveFashionInfo(FashionDto dto) {
        Fashion fashion = new Fashion();
        fashion.setBrandName(dto.getBrandName());
        fashion.setCategory(dto.getCategory());
        fashion.setPrice(dto.getPrice());
        return fashionRepository.save(fashion);
    }

    // update
    public Fashion updateFashionInfo(Long id, FashionDto dto) {
        Optional<Fashion> optionalFashion = fashionRepository.findById(id);
        if (optionalFashion.isPresent()) {
            Fashion fashion = optionalFashion.get();
            fashion.setBrandName(dto.getBrandName());
            fashion.setCategory(dto.getCategory());
            fashion.setPrice(dto.getPrice());
            return fashionRepository.save(fashion);
        } else {
            throw new RuntimeException("Not found fashion info with id: " + id);
        }
    }

    // delete
    public void deleteFruitStore(Long id) {
        fashionRepository.deleteById(id);
    }

}
