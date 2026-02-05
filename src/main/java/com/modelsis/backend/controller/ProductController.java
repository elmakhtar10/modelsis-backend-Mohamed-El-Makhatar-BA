package com.modelsis.backend.controller;

import com.modelsis.backend.model.*;
import com.modelsis.backend.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductRepository productRepo;
    private final ProductTypeRepository typeRepo;

    @GetMapping("/product") //
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @PostMapping("/productType")
    public ResponseEntity<?> addType(@RequestBody ProductType type) {
        log.info("Ajout d'un type de produit : {}", type.getName());
        if (typeRepo.existsByName(type.getName())) {
            return ResponseEntity.badRequest().body("Le type existe déjà !"); // Erreur 400
        }
        return ResponseEntity.ok(typeRepo.save(type));
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        log.info("Ajout d'un produit : {}", product.getName());
        if (productRepo.existsByName(product.getName())) {
            return ResponseEntity.status(400).body("Produit déjà existant"); // [cite: 39]
        }
        return ResponseEntity.ok(productRepo.save(product));
    }

    @PutMapping("/product")
    public ResponseEntity<?> update(@RequestBody Product product) {
        log.info("Mise à jour du produit ID : {}", product.getId());
        if (!productRepo.existsById(product.getId())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productRepo.save(product));
    }
}