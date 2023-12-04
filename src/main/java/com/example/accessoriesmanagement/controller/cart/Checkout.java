package com.example.accessoriesmanagement.controller.cart;

import com.example.accessoriesmanagement.entity.ShopOrder;
import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.service.IShopOrderService;
import com.example.accessoriesmanagement.service.IShoppingCartItemService;
import com.example.accessoriesmanagement.service.IShoppingCartService;
import com.example.accessoriesmanagement.service.Impl.ShopOrderServiceImpl;
import com.example.accessoriesmanagement.service.Impl.ShoppingCartItemServiceImpl;
import com.example.accessoriesmanagement.service.Impl.ShoppingCartServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/checkout")
public class Checkout extends HttpServlet {
    IShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
    IShopOrderService shopOrderService = new ShopOrderServiceImpl();

    IShoppingCartItemService shoppingCartItemService = new ShoppingCartItemServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("acc");


        Long shopping_cart_id = Long.valueOf((req.getParameter("cpid")));
        ShoppingCart shoppingCart =  shoppingCartService.getShoppingCartById(shopping_cart_id);

        //tạo 1 shopOrder link với user
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setUser(user);

        shopOrderService.insertShopOrder(shopOrder);

        List<ShoppingCartItem> shoppingCartItems =  shoppingCart.getShoppingCartItems();
        for(ShoppingCartItem s:shoppingCartItems){

        }

        for(ShoppingCartItem s:shoppingCartItems){
            shoppingCartItemService.deleteShoppingCartItemById(s.getShoppingCartItemId());
        }
        shoppingCartService.deleteShoppingCartById(shopping_cart_id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cart.jsp");
        dispatcher.forward(req, resp);

    }
}