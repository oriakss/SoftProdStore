package com.softprod.mappers;

import com.softprod.entities.Product;

import javax.servlet.http.HttpServletRequest;

import static com.softprod.utils.Constants.*;
import static java.lang.Double.parseDouble;

public class ProductMapper {

    public Product buildProduct(HttpServletRequest req) {
        return Product.builder()
                .name(req.getParameter(PRODUCT_NAME))
                .brand(req.getParameter(PRODUCT_BRAND))
                .category(req.getParameter(PRODUCT_CATEGORY))
                .price(parseDouble(req.getParameter(PRODUCT_PRICE)))
                .build();
    }
}
