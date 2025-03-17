package com.demo.example.repository;

import com.demo.example.entity.Product;
import com.demo.example.entity.PromoCodes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoCodesRepository extends JpaRepository<PromoCodes,String> {
}
