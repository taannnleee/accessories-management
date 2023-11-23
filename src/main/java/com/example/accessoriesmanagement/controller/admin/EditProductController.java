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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        System.out.println(action);

        if(action.equals("eidtProduct")){
            Long product_id = Long.valueOf(req.getParameter("product_id"));
            System.out.println(product_id);
            ProductDTO productEdit =  productService.getProductById(product_id);

            //set product Edit
            String name = req.getParameter("name");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            double price = Double.parseDouble(req.getParameter("price"));

            productEdit.setProductName(name);
            productEdit.setProductQuantity(quantity);
            productEdit.setProductPrice(price);

            productService.update(productEdit);
            RequestDispatcher rd = req.getRequestDispatcher("/success.jsp");
            rd.forward(req, resp);
        }
        else  if( action.equals("getProductEdit")){
            Long product_id = Long.valueOf(req.getParameter("product_id"));
            ProductDTO getProductEditDTO =  productService.getProductById(product_id);
            req.setAttribute("productEditDTO",getProductEditDTO);
            RequestDispatcher rd = req.getRequestDispatcher("/get_product_edit.jsp");
            rd.forward(req, resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
