package com.softprod.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Constants {

    public static final String ID = "id";
    public static final String USER_FIRSTNAME = "firstname";
    public static final String USER_SURNAME = "surname";
    public static final String USER_EMAIL = "email";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_ROLE = "userRole";
    public static final String USERS = "users";
    public static final String PRODUCT_NAME = "name";
    public static final String PRODUCT_BRAND = "brand";
    public static final String PRODUCT_CATEGORY = "category";
    public static final String PRODUCT_PRICE = "price";
    public static final String PRODUCTS = "products";
    public static final String ORDER_PRICE = "totalPrice";
    public static final String ORDER_PRODUCTS_NUM = "productsNum";
    public static final String ORDER_STATUS = "status";
    public static final String ORDERS = "orders";

    public static final String USERS_CREATE = "/users/create";
    public static final String USERS_READ = "/users/read";
    public static final String USERS_UPDATE = "/users/update";
    public static final String USERS_DELETE = "/users/delete";
    public static final String USERS_MENU = "/users/menu";
    public static final String USERS_ALL_PAGES = "/users/*";
    public static final String USERS_CREATE_PAGE = "/pages/users/create-user.jsp";
    public static final String USERS_READ_PAGE = "/pages/users/read-users.jsp";
    public static final String USERS_MENU_PAGE = "/pages/users/users-menu.jsp";

    public static final String PRODUCTS_CREATE = "/products/create";
    public static final String PRODUCTS_READ = "/products/read";
    public static final String PRODUCTS_UPDATE = "/products/update";
    public static final String PRODUCTS_DELETE = "/products/delete";
    public static final String PRODUCTS_MENU = "/products/menu";
    public static final String PRODUCTS_ALL_PAGES = "/products/*";
    public static final String PRODUCTS_CREATE_PAGE = "/pages/products/create-product.jsp";
    public static final String PRODUCTS_READ_PAGE = "/pages/products/read-products.jsp";
    public static final String PRODUCTS_MENU_PAGE = "/pages/products/products-menu.jsp";

    public static final String ORDERS_CREATE = "/orders/create";
    public static final String ORDERS_READ = "/orders/read";
    public static final String ORDERS_UPDATE = "/orders/update";
    public static final String ORDERS_DELETE = "/orders/delete";
    public static final String ORDERS_MENU = "/orders/menu";
    public static final String ORDERS_ALL_PAGES = "/orders/*";
    public static final String ORDERS_CREATE_PAGE = "/pages/orders/create-order.jsp";
    public static final String ORDERS_READ_PAGE = "/pages/orders/read-orders.jsp";
    public static final String ORDERS_MENU_PAGE = "/pages/orders/orders-menu.jsp";

    public static final String LOGIN = "/login";
    public static final String REGISTRATION = "/registration";
    public static final String ADMIN_MENU = "/admin-menu";
    public static final String ADMIN_MENU_PAGE = "/pages/admin-menu.jsp";
    public static final String LOGIN_ERROR = "/pages/errors/login-error.jsp";
    public static final String ACCESS_ERROR = "/pages/errors/access-error.jsp";
    public static final String REGISTRATION_ERROR = "/pages/errors/registration-error.jsp";
    public static final String REGISTRATION_PAGE = "/pages/registration.jsp";
}