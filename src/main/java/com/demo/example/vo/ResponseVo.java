package com.demo.example.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVo {
    private String productId;
    private Long originalPrice;
    private Long finalPrice;
    private DiscountVo appliedDiscounts;
    private Long totalSavings;
}
