package com.modelsis.backend.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private LocalDate dateCreated = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private ProductType type;
}