package com.example.accessoriesmanagement.controller.admin;

import com.example.accessoriesmanagement.controller.DTO.ProductCategoryDTO;
import com.example.accessoriesmanagement.controller.DTO.ProductDTO;
import com.example.accessoriesmanagement.service.IProductCategoryService;
import com.example.accessoriesmanagement.service.IProductService;
import com.example.accessoriesmanagement.service.Impl.ProductCategoryServiceImpl;
import com.example.accessoriesmanagement.service.Impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/add_product")
@MultipartConfig
public class AddProductController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    IProductCategoryService productCategoryService = new ProductCategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        List<ProductCategoryDTO> categoryList = productCategoryService.selectProductCategory();
        req.setAttribute("CATEGORY", categoryList);

        RequestDispatcher rd = req.getRequestDispatcher("/add_product.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String description = req.getParameter("title");
        String img = req.getParameter("image");
        Double price = Double.valueOf(req.getParameter("price"));
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));
        Long categoryId = Long.valueOf(req.getParameter("category"));
        try {
            ProductDTO productDTO = new ProductDTO(name, description, price, img, quantity, categoryId);
            productService.insertProduct(productDTO);
            RequestDispatcher rd = req.getRequestDispatcher("/success.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(); // In ra stack trace để ghi nhận lỗi

            RequestDispatcher errorDispatcher = req.getRequestDispatcher("/error.jsp");
            errorDispatcher.forward(req, resp);
        }

    }
}
