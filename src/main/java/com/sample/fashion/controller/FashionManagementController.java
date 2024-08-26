package com.sample.fashion.controller;

import com.sample.fashion.model.dto.FashionDto;
import com.sample.fashion.model.entity.Fashion;
import com.sample.fashion.service.FashionManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fashions")
public class FashionManagementController {

    private final FashionManagementService fashionService;

    @Autowired
    public FashionManagementController(FashionManagementService fashionService) {
        this.fashionService = fashionService;
    }

    /**
     * 브랜드 및 상품 정보 신규 추가
     *
     * @requestBody dto 추가할 브랜드 상품 정보
     *               {
     *                 "brandName": "O",
     *                 "category": "상의",
     *                 "price": 8900
     *               }
     * @return ResponseEntity (추가된 정보 / HttpStatus)
     */
    @PostMapping
    public ResponseEntity<Fashion> save(@RequestBody FashionDto dto) {
        Fashion fashion = fashionService.saveFashionInfo(dto);
        return new ResponseEntity<>(fashion, HttpStatus.CREATED);
    }

    /**
     * 브랜드 및 상품 정보 수정
     *
     * @param id 수정 대상 번호
     * @requestBody dto 업데이트할 브랜드 상품 정보
     *               {
     *                 "brandName": "A",
     *                 "category": "상의",
     *                 "price": 4600
     *               }
     * @return ResponseEntity (수정된 정보 / HttpStatus)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Fashion> update(@PathVariable Long id, @RequestBody FashionDto dto) {
        try {
            Fashion fashion = fashionService.updateFashionInfo(id, dto);
            return new ResponseEntity<>(fashion, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * 특정 브랜드 및 상품 정보 삭제
     *
     * @param id 삭제 대상 번호
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        fashionService.deleteFruitStore(id);
        return ResponseEntity.noContent().build();
    }

}

