package com.modelsis.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.modelsis.backend.model.Product;
import com.modelsis.backend.model.ProductType;
import com.modelsis.backend.repository.ProductRepository;
import com.modelsis.backend.repository.ProductTypeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper; // Pour transformer les objets en JSON

    @Autowired
    private ProductTypeRepository typeRepository;

    @Test
    @DisplayName("Test de la contrainte d'unicité sur le nom du produit")
    void testUniciteNomProduit() throws Exception {
        ProductType type = new ProductType();
        type.setName("Electronique");
        typeRepository.save(type);

        Product p1 = new Product();
        p1.setName("PC Portable");
        p1.setType(type);

        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(p1)))
                .andExpect(status().isOk());

        Product p2 = new Product();
        p2.setName("PC Portable");
        p2.setType(type);

        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(p2)))
                .andExpect(status().isBadRequest());
    }
}