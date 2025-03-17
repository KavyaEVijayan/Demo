package com.demo.example.controller;

import com.demo.example.service.ProductService;
import com.demo.example.vo.RequestVo;
import com.demo.example.vo.ResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
private  final ProductService productService;
    @GetMapping("/price-calculation")
    public ResponseVo getpriceDetails(@RequestBody RequestVo requestVo) {
      return productService.discountCalculations(requestVo);
    }
}
