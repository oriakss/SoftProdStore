package com.softprod.controllers;

import com.softprod.entities.Product;
import com.softprod.mappers.ProductMapper;
import com.softprod.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softprod.services.ProductServiceImpl.getInstance;
import static com.softprod.utils.Constants.*;

@WebServlet(urlPatterns = PRODUCTS_CREATE)
public class CreateProductController extends HttpServlet {

    private final ProductService productService = getInstance();
    private final ProductMapper productMapper = new ProductMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PRODUCTS_CREATE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = productMapper.buildProduct(req);
        productService.createProduct(product);
        req.getRequestDispatcher(PRODUCTS_MENU).forward(req, resp);
    }
}
