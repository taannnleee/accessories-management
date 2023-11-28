package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.controller.DTO.ProductDTO;
import com.example.accessoriesmanagement.service.IProductService;
import com.example.accessoriesmanagement.service.Impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail_product")
public class DetailProductController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url ="index";

        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String product_id = req.getParameter("product_id");
        ProductDTO productDTO =  productService.getProductById(Long.valueOf(product_id));
        req.setAttribute("productDetail",productDTO);

        RequestDispatcher rd = req.getRequestDispatcher("/detailProduct.jsp");
        rd.forward(req, resp);

    }
}
