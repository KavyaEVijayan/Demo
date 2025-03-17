package com.demo.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Long basePrice;
    @Column
    private String category;
    @Column
    private Integer availableQuantity;



}
