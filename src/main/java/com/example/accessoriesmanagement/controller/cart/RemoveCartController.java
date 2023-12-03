package com.example.accessoriesmanagement.controller.cart;

import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.service.IShoppingCartItemService;
import com.example.accessoriesmanagement.service.IShoppingCartService;
import com.example.accessoriesmanagement.service.Impl.ShoppingCartItemServiceImpl;
import com.example.accessoriesmanagement.service.Impl.ShoppingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Handler;

@WebServlet("/remove_cart")
public class RemoveCartController extends HttpServlet {
    IShoppingCartItemService shoppingCartItemService = new ShoppingCartItemServiceImpl();

    IShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Long cart_id = Long.valueOf((req.getParameter("cid")));

        ShoppingCartItem shoppingCartItem  = shoppingCartItemService.getShoppingCartItemById(cart_id);

        System.out.println(shoppingCartItem.getShoppingCartItemId());
        System.out.println(shoppingCartItem.getProduct().getProductName());

        shoppingCartItemService.deleteShoppingCartItem(shoppingCartItem);
        System.out.println("xóa");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
