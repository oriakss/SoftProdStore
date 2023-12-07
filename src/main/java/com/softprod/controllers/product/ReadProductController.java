package com.softprod.controllers.product;

import com.softprod.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softprod.services.ProductServiceImpl.getInstance;
import static com.softprod.utils.Constants.*;

@WebServlet(urlPatterns = PRODUCTS_READ)
public class ReadProductController extends HttpServlet {

    private final ProductService productService = getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(PRODUCTS, productService.readProducts());
        req.getRequestDispatcher(PRODUCTS_READ_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}