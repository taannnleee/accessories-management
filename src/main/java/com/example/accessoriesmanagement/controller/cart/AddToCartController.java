package com.example.accessoriesmanagement.controller.cart;

import com.example.accessoriesmanagement.Mapper.Mappers;
import com.example.accessoriesmanagement.controller.DTO.ProductDTO;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.service.IProductService;
import com.example.accessoriesmanagement.service.Impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add_to_cart")
public class AddToCartController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "view_cart";
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("acc");
        String product_id = req.getParameter("product_id");
        String quantity = req.getParameter("quantity");

        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUser(user);
            session.setAttribute("shoppingCart", shoppingCart);
        }
        //System.out.println(session.getAttribute("shoppingCart"));


        Long productId = Long.valueOf(product_id);
        ProductDTO productDTO = productService.getProductById(productId);


        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProduct(Mappers.convertToEntity(productDTO,Product.class));

        shoppingCartItem.setShopping_cart(shoppingCart);
        shoppingCartItem.setShoppingCartItemQuantity(quantity);


        resp.sendRedirect(url);

    }

}
