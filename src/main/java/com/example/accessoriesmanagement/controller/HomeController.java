package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.DAO.IProductDao;
import com.example.accessoriesmanagement.DAO.ProductDaoImpl;
import com.example.accessoriesmanagement.entity.Product;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeControl", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    private final IProductDao productDao = new ProductDaoImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Product> allProducts = productDao.getAllProducts();
        List<Product> top4adidas = productDao.get4AdidasLast();
        List<Product> top4nike = productDao.get4NikeLast();

        request.setAttribute("allP", allProducts);
        request.setAttribute("allA", top4adidas);
        request.setAttribute("allN", top4nike);
        request.getRequestDispatcher("views/Home.jsp").forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("home");
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
