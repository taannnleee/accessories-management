package com.example.accessoriesmanagement.controller.admin;

import com.example.accessoriesmanagement.controller.DTO.ProductCategoryDTO;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ProductCategory;
import com.example.accessoriesmanagement.service.IProductCategoryService;
import com.example.accessoriesmanagement.service.IProductService;
import com.example.accessoriesmanagement.service.ProductCategoryServiceImpl;
import com.example.accessoriesmanagement.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Locale;

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
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        String quantity = req.getParameter("quantity");
        
        Part file = req.getPart("image_multipart");
        String imageFileName = file.getSubmittedFileName();
        String uploadPath = "C:/Users/Admin/Downloads/DoAnLTWeb/accessories-management/src/main/webapp/static/"+ imageFileName;
        try {
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }






        RequestDispatcher rd = req.getRequestDispatcher("/success.jsp");
        rd.forward(req, resp);

    }
}
