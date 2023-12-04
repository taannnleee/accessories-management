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

@WebServlet("/edit_product")
public class EditProductController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        System.out.println(action);

        Long product_id = Long.valueOf(req.getParameter("id"));
        System.out.println(product_id);
        ProductDTO productEdit =  productService.getProductById(product_id);

        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String title = req.getParameter("title");
        String img = req.getParameter("image");
        Long idcate = Long.valueOf(req.getParameter("category"));
        productEdit.setProductName(name);
        productEdit.setProductPrice(price);
        productEdit.setProductDescription(title);
        productEdit.setProductImage(img);
        productEdit.setProductCategoryId(idcate);

        productService.update(productEdit);
        RequestDispatcher rd = req.getRequestDispatcher("/success.jsp");
        rd.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
