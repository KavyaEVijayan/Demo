package com.demo.example.repository;

import com.demo.example.entity.QuantityDiscounts;
import com.demo.example.entity.UserTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityDiscountsRepository extends JpaRepository<QuantityDiscounts,Long> {
    QuantityDiscounts findByMinQuantity(Integer quantity);
}
