package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.entity.ShopOrder;
import com.example.accessoriesmanagement.entity.ShopOrderLineItem;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.entity.User;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        //User user = (User) session.getAttribute("acc");
        User user = userService.getUserById(1L);
        User user_temp =  userService.getUserById(user.getUserID());

        System.out.println("ID user là");
        System.out.println(user_temp.getUserName());
        //System.out.println(user_temp.getShopOders());
        if(user.getShopOders()!=null){
            System.out.println("khac null");
        }
        else {
            System.out.println("null");
        }

       // if(shopOrders!=null){

//        for(ShopOrder a : user_temp.getShopOders()){
//            System.out.println(a.getShopOrderLineItems());
//            System.out.println(a.getCustomerEmail());
//            for(ShopOrderLineItem b : a.getShopOrderLineItems()){
//                System.out.println(b.getQuantity());
//            }
//        }





        //tạo ra list để load dữ liệu lên
        //Hibernate.initialize(shopOrderService.getShopOrderById());


        //List<ShopOrder> shopOrders = new ArrayList<>();
        //List<ShopOrder> shopOrders = shopOrderService.getShopOrderById(1L);
//        if(shopOrders!=null){
//            System.out.println("khac null");
//        }
//        else {
//            System.out.println("null");
//        }
//
//        if(shopOrders!=null){
//            for(ShopOrder so:shopOrders){
//                //ShopOrder shopOrder =  shopOrderService.getShopOrderById(so.getShopOrderId());
//                //List<ShopOrderLineItem> shopOrderLineItems = shopOrder.getShopOrderLineItems();
//            }
//            req.setAttribute("shopOrders", shopOrders);
//
//        }else{
//            System.out.println("Ban chưa thực hiện order nào cả");
//        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/history.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
