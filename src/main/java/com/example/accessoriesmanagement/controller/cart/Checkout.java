package com.example.accessoriesmanagement.controller.cart;

import com.example.accessoriesmanagement.controller.DTO.ProductDTO;
import com.example.accessoriesmanagement.controller.model.ShoppingCartItemInfo;
import com.example.accessoriesmanagement.entity.*;
import com.example.accessoriesmanagement.service.*;
import com.example.accessoriesmanagement.service.Impl.*;
import com.example.accessoriesmanagement.utils.DateUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/checkout")
public class Checkout extends HttpServlet {
    IShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
    IShopOrderService shopOrderService = new ShopOrderServiceImpl();

    IShoppingCartItemService shoppingCartItemService = new ShoppingCartItemServiceImpl();

    IShopOrderLineItemService shopOrderLineItemService = new ShopOrderLineItemServiceImpl();


    IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String customerFirstName = (req.getParameter("customerFirstName"));
        String customerLastName =(req.getParameter("customerLastName"));
        String customerPhone = (req.getParameter("customerPhone"));
        String customerEmail =(req.getParameter("customerEmail"));
        String customerAddress = (req.getParameter("customerAddress"));

        System.out.println(customerLastName);
        System.out.println(customerFirstName);


        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("acc");

        Long shopping_cart_id = Long.valueOf((req.getParameter("cpid")));
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(shopping_cart_id);

        String action = req.getParameter("action");
        if(action.equals("payment")){

            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            System.out.println(date);

            //tạo mới một Order
            ShopOrder shopOrder = new ShopOrder();
            shopOrder.setUser(user);
            shopOrder.setOrderStatus("paid");
            shopOrder.setOrderDate(date);
            shopOrder.setCustomerLastName(customerLastName);
            shopOrder.setCustomerFirstName(customerFirstName);
            shopOrder.setCustomerEmail(customerEmail);
            shopOrder.setCustomerPhone(customerPhone);
            shopOrder.setAddressShipping(customerAddress);

            shopOrder.setTotalPrice(shoppingCart.getTotalPrice());
            shopOrderService.insertShopOrder(shopOrder);

            //gan item qua cho shopOrderItem
            List<ShoppingCartItem> shoppingCartItems = shoppingCart.getShoppingCartItems();
            for (ShoppingCartItem s : shoppingCartItems) {
                ShopOrderLineItem shopOrderItem = new ShopOrderLineItem();

                shopOrderItem.setSize(s.getSize());
                shopOrderItem.setQuantity(s.getShoppingCartItemQuantity());
                shopOrderItem.setProduct(s.getProduct().getProductID());
                // Gán shopOrder cho shopOrderItem
                shopOrderItem.setShopOrder(shopOrder);

                shopOrderLineItemService.insertShopOrderLineItem(shopOrderItem);
            }


            for (ShoppingCartItem s : shoppingCartItems) {
                shoppingCartItemService.deleteShoppingCartItemById(s.getShoppingCartItemId());
            }
            shoppingCartService.deleteShoppingCartById(shopping_cart_id);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/cart.jsp");
            dispatcher.forward(req, resp);
        }
        else if(action.equals("get_information")){

            List<ShoppingCartItem> shoppingCartItems = shoppingCart.getShoppingCartItems();
            List<ShoppingCartItemInfo> productBuys =  calculateItemTotals(shoppingCartItems);

            int size = productBuys.size();
            double totalPrice = calculateTotalPrice(shoppingCartItems);
            req.setAttribute("size", size);
            req.setAttribute("totalPrice", totalPrice);
            req.setAttribute("productBuys", productBuys);
            req.setAttribute("shoppingCart", shoppingCart);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/payment.jsp");
            dispatcher.forward(req, resp);
        }
    }

    public double calculateTotalPrice(List<ShoppingCartItem> shoppingCartItems) {
        double totalPrice = 0.0;
        for (ShoppingCartItem item : shoppingCartItems) {
            ProductDTO productDTO = productService.getProductById(item.getProduct().getProductID());
            int quantity = Integer.parseInt(item.getShoppingCartItemQuantity());
            double pricePerUnit = productDTO.getProductPrice();

            double itemTotal = quantity * pricePerUnit;
            totalPrice += itemTotal;
        }
        return totalPrice;
    }
    public List<ShoppingCartItemInfo> calculateItemTotals(List<ShoppingCartItem> shoppingCartItems) {
        List<ShoppingCartItemInfo> itemInfoList = new ArrayList<>();

        for (ShoppingCartItem item : shoppingCartItems) {
            ProductDTO productDTO = productService.getProductById(item.getProduct().getProductID());
            int quantity = Integer.parseInt(item.getShoppingCartItemQuantity());
            double pricePerUnit = productDTO.getProductPrice();

            double itemTotal = quantity * pricePerUnit;

            ShoppingCartItemInfo itemInfo = new ShoppingCartItemInfo(item, itemTotal);
            itemInfoList.add(itemInfo);
        }

        return itemInfoList;
    }


}