package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.repositories.Impl.CategoryDaoImpl;
import com.example.accessoriesmanagement.repositories.ICategoryDao;
import com.example.accessoriesmanagement.repositories.IProductDao;
import com.example.accessoriesmanagement.repositories.Impl.ProductDaoImpl;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ProductCategory;

import java.io.IOException;
import java.util.List;
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

        List<Product> list = productDAO.getProductByIndex(indexPage);
        List<Product> allP = productDAO.getAllProducts();
        List<ProductCategory> listC = categoryDAO.getAllCategory();
        String cateID = request.getParameter("cid");

        long allProduct = productDAO.countAllProduct();

        long end  = allProduct / 9;
        if (allProduct % 9 != 0) {
            end++;
        }
        request.setAttribute("tag", indexPage);
        request.setAttribute("endPage", end);
        request.setAttribute("listC", listC);
        request.setAttribute("listP", list);
        request.setAttribute("cateid", cateID);

        request.getRequestDispatcher("views/Shop.jsp").forward(request, response);

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
