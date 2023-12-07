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
import static java.lang.Long.parseLong;

@WebServlet(urlPatterns = PRODUCTS_DELETE)
public class DeleteProductController extends HttpServlet {

    private final ProductService productService = getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService.deleteProduct(parseLong(req.getParameter(ID)));
        req.getRequestDispatcher(PRODUCTS_MENU).forward(req, resp);
    }
}