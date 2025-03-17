package com.demo.example.service;


import com.demo.example.entity.Product;
import com.demo.example.entity.PromoCodes;
import com.demo.example.entity.QuantityDiscounts;
import com.demo.example.entity.UserTypes;
import com.demo.example.repository.ProductRepository;
import com.demo.example.repository.PromoCodesRepository;
import com.demo.example.repository.QuantityDiscountsRepository;
import com.demo.example.repository.UserTypesRepository;
import com.demo.example.vo.RequestVo;
import com.demo.example.vo.ResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final PromoCodesRepository promoCodesRepository;
    private final UserTypesRepository userTypesRepository;
    private final QuantityDiscountsRepository quantityDiscountsRepository;

    public ResponseVo discountCalculations(RequestVo requestVo) {
        ResponseVo responseVo = new ResponseVo();
        if (requestVo.getProductId() != null) {
            Product product = productRepository.getById(requestVo.getProductId());
            Long BasePrice = product.getBasePrice();
            Long FinalPrice=BasePrice* requestVo.getQuantity();
            PromoCodes promoCodes = null;
            UserTypes userTypes = null;
            QuantityDiscounts quantityDiscounts = null;
            Long price = 0L;
            if (requestVo.getPromoCode() != null) {
                promoCodes = promoCodesRepository.getById(requestVo.getPromoCode());
            }
            if (requestVo.getUserType() != null) {
                userTypes = userTypesRepository.getById(requestVo.getUserType());
            }
//            if (requestVo.getQuantity() > 3) {
            quantityDiscounts = quantityDiscountsRepository.findByMinQuantity(requestVo.getQuantity());
//            }

            if (!Objects.isNull(promoCodes)) {
                Long promoDiscount = promoCodes.getDiscountPercentage();
               Long discount = FinalPrice * promoDiscount/100;
                price = discount;
            }
            if (!Objects.isNull(userTypes)) {
                Long userDiscount = userTypes.getDiscountPercentage();
                Long discount = FinalPrice * userDiscount / 100;
                price = discount;
            }
            if (!Objects.isNull(quantityDiscounts)) {
                Long quantityDiscount = quantityDiscounts.getDiscountPercentage();
                Long discount = FinalPrice * quantityDiscount / 100;
                price = discount;
            }
//            Long FinalPrice = BasePrice;
            responseVo.setProductId(requestVo.getProductId());
            responseVo.setOriginalPrice(product.getBasePrice()*requestVo.getQuantity());
            responseVo.setFinalPrice(price);
//            responseVo.getAppliedDiscounts().setType();
            responseVo.setTotalSavings(FinalPrice-price);

        }
        return responseVo;
    }

}
