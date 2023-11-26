package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.DAO.CategoryDaoImpl;
import com.example.accessoriesmanagement.DAO.ICategoryDao;
import com.example.accessoriesmanagement.DAO.IProductDao;
import com.example.accessoriesmanagement.DAO.ProductDaoImpl;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ProductCategory;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShopControl", urlPatterns = {"/shop"})
public class ShopController extends HttpServlet {

    private final IProductDao productDAO = new ProductDaoImpl();
    private final ICategoryDao categoryDAO = new CategoryDaoImpl();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);


        try {
            List<Product> list = productDAO.getProductByIndex(indexPage);
            List<Product> allP = productDAO.getAllProducts();
            List<ProductCategory> listC = categoryDAO.getAllCategory();

            System.out.println("Number of cate: " + listC.size());

            System.out.println("Number of pro: " + list.size());
            long allProduct = productDAO.countAllProduct();
            System.out.println("Number of n: " + allProduct);

            long end  = allProduct / 9;
            if (allProduct % 9 != 0) {
                end++;
            }

            request.setAttribute("tag", indexPage);
            request.setAttribute("endPage", end);
            request.setAttribute("listC", listC);
            request.setAttribute("listP", allP);

            request.getRequestDispatcher("Shop.jsp").forward(request, response);
        } finally {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
