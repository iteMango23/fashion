package com.sample.fashion.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Fashion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            //seq
    private String brandName;   //브랜드명
    private String category;    //카테고리
    private double price;       //가격

    public Fashion() {
    }

    public Fashion(String brandName, String category, double price) {
        this.brandName = brandName;
        this.category = category;
        this.price = price;
    }
}
