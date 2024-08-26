package com.sample.fashion.repository;

import com.sample.fashion.model.entity.Fashion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FashionRepository extends JpaRepository<Fashion, Long> {
    List<Fashion> findByCategory(String category);
}
