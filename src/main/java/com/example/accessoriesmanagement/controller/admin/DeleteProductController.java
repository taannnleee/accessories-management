package com.example.accessoriesmanagement.controller.admin;

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

@WebServlet("/delete_product")
public class DeleteProductController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        Long product_id = Long.valueOf(req.getParameter("pid"));
        ProductDTO getProductDelete =  productService.getProductById(product_id);
        //productService.delete(getProductDelete);
        productService.deleteProductById(getProductDelete.getProductID());

        System.out.println("ID:");
        System.out.println(getProductDelete.getProductID());

        RequestDispatcher rd = req.getRequestDispatcher("manager_product_list");
        rd.forward(req, resp);
    }
}
