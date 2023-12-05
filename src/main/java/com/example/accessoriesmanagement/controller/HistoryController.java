package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.entity.ShopOrder;
import com.example.accessoriesmanagement.entity.ShopOrderLineItem;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.repositories.IShopCartDao;
import com.example.accessoriesmanagement.repositories.Impl.ShopCartImpl;
import com.example.accessoriesmanagement.service.IShopOrderService;
import com.example.accessoriesmanagement.service.IUserService;
import com.example.accessoriesmanagement.service.Impl.ShopOrderServiceImpl;
import com.example.accessoriesmanagement.service.Impl.UserServiceImpl;
import org.hibernate.Hibernate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/history")
public class HistoryController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    IShopOrderService shopOrderService = new ShopOrderServiceImpl();
    IShopCartDao shopCartDao = new ShopCartImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        User a = (User) session.getAttribute("acc");
        Long id = a.getUserID();

        List<ShopOrder> allO = shopCartDao.getAllInvoiceByID(id);
        System.out.println(allO.size());
        req.setAttribute("shopOrders", allO);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/history.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
