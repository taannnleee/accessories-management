package com.example.accessoriesmanagement.controller.cart;

import com.example.accessoriesmanagement.Mapper.Mappers;
import com.example.accessoriesmanagement.controller.DTO.ProductDTO;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.service.IProductService;
import com.example.accessoriesmanagement.service.IShoppingCartItemService;
import com.example.accessoriesmanagement.service.IShoppingCartService;
import com.example.accessoriesmanagement.service.IUserService;
import com.example.accessoriesmanagement.service.Impl.ProductServiceImpl;
import com.example.accessoriesmanagement.service.Impl.ShoppingCartItemServiceImpl;
import com.example.accessoriesmanagement.service.Impl.ShoppingCartServiceImpl;
import com.example.accessoriesmanagement.service.Impl.UserServiceImpl;

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

@WebServlet("/addCart")
public class AddToCartController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    IShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    IShoppingCartItemService shoppingCartItemService = new ShoppingCartItemServiceImpl();

    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            String product_id = req.getParameter("pid");
            String quantity = req.getParameter("quantity");
            String size = req.getParameter("size");

            Long productId = Long.valueOf(product_id);
            ProductDTO productDTO = productService.getProductById(productId);

            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("acc");
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

            ShoppingCart shoppingCart_temp = (ShoppingCart) session.getAttribute("shoppingCart");
            shoppingCart = shoppingCartService.getShoppingCartById(shoppingCart_temp.getShoppingId());

            if (user != null) {

                if(shoppingCart !=null){
                    if (shoppingCart.getShoppingCartItems() != null) {
                        boolean productExistsInCart = false;
                        List<ShoppingCartItem> shoppingCartItems = shoppingCart.getShoppingCartItems();
                        //update so lượng khi cùng một loại san phẩm
                        for (ShoppingCartItem item : shoppingCartItems) {
                            if (item.getProduct().getProductID().equals(productDTO.getProductID()) && item.getSize().equals(size)) {
                                // Nếu sản phẩm đã tồn tại trong giỏ hàng, cập nhật số lượng
                                int newQuantity = Integer.parseInt(item.getShoppingCartItemQuantity()) + Integer.parseInt(quantity);
                                item.setShoppingCartItemQuantity(String.valueOf(newQuantity));
                                productExistsInCart = true;
                                shoppingCartItemService.updateShoppingCartItem(item);
                                break;
                            }
                        }
                        if (!productExistsInCart) {
                            ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
                            shoppingCartItem.setProduct(Mappers.convertToEntity(productDTO, Product.class));
                            shoppingCartItem.setShoppingCartItemQuantity(quantity);
                            shoppingCartItem.setSize(size);
                            shoppingCartItem.setShopping_cart(shoppingCart);
                            //them vào database
                            shoppingCartItemService.updateShoppingCartItem(shoppingCartItem);
                        }
                    } else {
                        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
                        shoppingCartItem.setProduct(Mappers.convertToEntity(productDTO, Product.class));
                        shoppingCartItem.setShoppingCartItemQuantity(quantity);
                        shoppingCartItem.setSize(size);
                        shoppingCartItem.setShopping_cart(shoppingCart);
                        //them vào database
                        shoppingCartItemService.updateShoppingCartItem(shoppingCartItem);
                    }
                }else{
                    ShoppingCart shoppingCart1 = new ShoppingCart();
                    shoppingCart1.setUser(user);
                    shoppingCart1.setTotalPrice(0);

                    ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
                    shoppingCartItem.setProduct(Mappers.convertToEntity(productDTO, Product.class));
                    shoppingCartItem.setSize(size);
                    shoppingCartItem.setShoppingCartItemQuantity(quantity);
                    shoppingCartItem.setShopping_cart(shoppingCart1);
                    //them vào database
                    ShoppingCartItem shoppingCartItem1 =  shoppingCartItemService.updateShoppingCartItem(shoppingCartItem);

                    session.setAttribute("shoppingCart", shoppingCartItem1.getShopping_cart());
                }
            }
            resp.sendRedirect("view_cart");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Có lỗi xảy ra: " + e.getMessage()); // In ra thông điệp lỗi nếu cần
        }

    }


}
