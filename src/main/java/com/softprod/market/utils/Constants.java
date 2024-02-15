package com.softprod.market.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Constants {

    public static final String ID = "id";
    public static final String CUSTOMER_LOWER = "customer";
    public static final String PRODUCTS = "products";
    public static final String BASKET = "basket";

    public static final String API_URL = "api/v1";
    public static final String CUSTOMERS_URL = "customers";
    public static final String PURCHASE_URL = "purchase";
    public static final String PURCHASES_URL = "purchases";
    public static final String PRODUCT_URL = "product";
    public static final String PURCHASE_ID_URL = "purchase/{id}";
    public static final String PRODUCT_ID_URL = "product/{id}";
    public static final String CUSTOMER_ID_URL = "customer/{id}";
    public static final String ADD_PRODUCT_TO_BASKET_URL = "customer/{id}/basket/add_product";
    public static final String REMOVE_PRODUCT_FROM_BASKET_URL = "customer/{id}/basket/remove_product";

    public static final String ID_COLUMN = "ID";
    public static final String NAME_COLUMN = "NAME";
    public static final String EMAIL_COLUMN = "EMAIL";
    public static final String LOGIN_COLUMN = "LOGIN";
    public static final String PASSWORD_COLUMN = "PASSWORD";
    public static final String ROLE_COLUMN = "ROLE";
    public static final String BRAND_COLUMN = "BRAND";
    public static final String CATEGORY_COLUMN = "CATEGORY";
    public static final String PRICE_COLUMN = "PRICE";
    public static final String STATUS_COLUMN = "STATUS";
    public static final String TOTAL_PRICE_COLUMN = "TOTAL_PRICE";
    public static final String PRODUCTS_NUM_COLUMN = "PRODUCTS_NUM";

    public static final String CUSTOMER = "CUSTOMER";
    public static final String PURCHASE = "PURCHASE";
    public static final String PRODUCT = "PRODUCT";
    public static final String CUSTOMER_PRODUCT = "CUSTOMER_PRODUCT";
    public static final String PURCHASE_PRODUCT = "PURCHASE_PRODUCT";
    public static final String CUSTOMER_ID = "CUSTOMER_ID";
    public static final String PURCHASE_ID = "PURCHASE_ID";
    public static final String PRODUCT_ID = "PRODUCT_ID";

    public static final String CUSTOMER_NOT_FOUND_MESSAGE_KEY = "customer.missing.message";
    public static final String PRODUCT_NOT_FOUND_MESSAGE_KEY = "product.missing.message";
    public static final String PURCHASE_NOT_FOUND_MESSAGE_KEY = "purchase.missing.message";
}