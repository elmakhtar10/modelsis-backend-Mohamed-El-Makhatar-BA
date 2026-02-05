package com.modelsis.backend.repository;

import com.modelsis.backend.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    boolean existsByName(String name);
}