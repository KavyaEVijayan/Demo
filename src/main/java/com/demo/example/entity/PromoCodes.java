package com.demo.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "promo_codes")
public class PromoCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String code;
    @Column
    private Long discountPercentage;
    @Column
    private Boolean active;
    @Column
    private Date validUntil;




}
