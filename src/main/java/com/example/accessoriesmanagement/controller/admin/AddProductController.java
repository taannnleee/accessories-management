package com.example.accessoriesmanagement.controller.admin;

import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ProductCategory;
import com.example.accessoriesmanagement.service.IProductCategoryService;
import com.example.accessoriesmanagement.service.IProductService;
import com.example.accessoriesmanagement.service.ProductCategoryServiceImpl;
import com.example.accessoriesmanagement.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@WebServlet("/add_product")
public class AddProductController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    IProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        List<ProductCategory> categoryList = productCategoryService.selectProductCategory();
        req.setAttribute("CATEGORY", categoryList);
        for(ProductCategory a : categoryList){
            System.out.println(a.getCategoryName());
        }

        RequestDispatcher rd =  req.getRequestDispatcher("/add_product.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name =req.getParameter("name");
        String description =req.getParameter("description");
        String price =req.getParameter("price");
        String quantity =req.getParameter("quantity");

    }
}
