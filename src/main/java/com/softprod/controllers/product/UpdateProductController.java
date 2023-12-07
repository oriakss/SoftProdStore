package com.softprod.controllers.product;

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
import static java.lang.Long.parseLong;

@WebServlet(urlPatterns = PRODUCTS_UPDATE)
public class UpdateProductController extends HttpServlet {

    private final ProductService productService = getInstance();
    private final ProductMapper productMapper = ProductMapper.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = productMapper.buildProduct(req);
        product.setId(parseLong((req.getParameter(ID))));
        productService.updateProduct(product);
        req.getRequestDispatcher(PRODUCTS_MENU).forward(req, resp);
    }
}