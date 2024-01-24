package com.softprod.mappers;

import com.softprod.entities.Product;
import com.softprod.entities.ProductCategory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

import static com.softprod.entities.ProductCategory.valueOf;
import static com.softprod.utils.Constants.*;

public class ProductMapper {

    private static ProductMapper productMapper;

    public Product buildProduct(HttpServletRequest req) {
        return Product.builder()
                .name(req.getParameter(PRODUCT_NAME))
                .brand(req.getParameter(PRODUCT_BRAND))
                .category(valueOf(req.getParameter(PRODUCT_CATEGORY)))
                .price(new BigDecimal(req.getParameter(PRODUCT_PRICE)))
                .build();
    }

    public Product buildProductManually(String name, String brand, ProductCategory category, BigDecimal price) {
        return Product.builder()
                .name(name)
                .brand(brand)
                .category(category)
                .price(price)
                .build();
    }

    public static ProductMapper getInstance() {
        if (productMapper == null) {
            productMapper = new ProductMapper();
        }
        return productMapper;
    }

    private ProductMapper() {
    }
}