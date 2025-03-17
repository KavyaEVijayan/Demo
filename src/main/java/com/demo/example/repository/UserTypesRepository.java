package com.demo.example.repository;

import com.demo.example.entity.Product;
import com.demo.example.entity.UserTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypesRepository extends JpaRepository<UserTypes,String> {
}
