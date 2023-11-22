package com.example.accessoriesmanagement.controller.cart;

import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add_to_cart")
public class AddToCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/home/cart";
        ServletContext sc = getServletContext();
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("acc");
        String product_id = req.getParameter("product_id");

        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }


//        LineItem lineItem = createLineItem(sc, product_id, 1);
//        cart.addItem(lineItem);
//        session.setAttribute("cart", cart);
//        resp.sendRedirect(url);
    }
//    private LineItem createLineItem(ServletContext sc, String productCode, int qtyToAdd) {
//        String path = sc.getRealPath("/WEB-INF/products.txt");
//        Product product = ProductIO.getProduct(productCode, path);
//
//        return new LineItem(product, qtyToAdd);
//    }
}
