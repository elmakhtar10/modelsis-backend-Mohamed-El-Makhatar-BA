package com.modelsis.backend.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) // [cite: 38]
    private String name;
}