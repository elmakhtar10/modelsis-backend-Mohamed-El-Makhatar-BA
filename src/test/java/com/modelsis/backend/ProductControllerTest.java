package com.modelsis.backend;

import com.modelsis.backend.controller.ProductController;
import com.modelsis.backend.model.Product;
import com.modelsis.backend.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

    @Test
    void testUniqueProductName() {
        Product p = new Product();
        p.setName("iPhone");
        when(productRepository.existsByName("iPhone")).thenReturn(true);

        ResponseEntity<?> response = productController.addProduct(p);

        assertEquals(400, response.getStatusCodeValue());
    }
}