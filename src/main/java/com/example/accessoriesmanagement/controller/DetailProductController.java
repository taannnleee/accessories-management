package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.repositories.ICategoryDao;
import com.example.accessoriesmanagement.repositories.IProductDao;
import com.example.accessoriesmanagement.repositories.Impl.CategoryDaoImpl;
import com.example.accessoriesmanagement.repositories.Impl.ProductDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DetailControl", urlPatterns = {"/detail"})
public class DetailProductController extends HttpServlet {
    private  final IProductDao productDao = new ProductDaoImpl();
    private final ICategoryDao categoryDao = new CategoryDaoImpl();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Long id = Long.valueOf((request.getParameter("pid")));

        Long cateID = categoryDao.getCateIDByProductID(id);

        Product p = productDao.getProductByIdProduct(id);
        List<Product> relateProduct = productDao.getRelatedProduct(cateID);

        request.setAttribute("listRelatedProduct", relateProduct);
        request.setAttribute("detail", p);
        request.getRequestDispatcher("ProductDetail.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}