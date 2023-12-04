package com.example.accessoriesmanagement.controller;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ProductCategory;
import com.example.accessoriesmanagement.entity.User;
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
import javax.servlet.http.HttpSession;


@WebServlet(name = "ManagerControl", urlPatterns = {"/manager"})
public class ProductManController extends HttpServlet {
    IProductDao productDao = new ProductDaoImpl();
    ICategoryDao categoryDao = new CategoryDaoImpl();

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

        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);

        List<Product> list = productDao.getProductByIndex(indexPage);
        List<Product> allP = productDao.getAllProducts();
        List<ProductCategory> listC = categoryDao.getAllCategory();
        String cateID = request.getParameter("cid");

        long allProduct = productDao.countAllProduct();

        long end  = allProduct / 9;
        if (allProduct % 9 != 0) {
            end++;
        }


        request.setAttribute("tag", indexPage);
        request.setAttribute("endPage", end);
        request.setAttribute("listC", listC);
        request.setAttribute("listP", list);
        request.getRequestDispatcher("ProductManager.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
