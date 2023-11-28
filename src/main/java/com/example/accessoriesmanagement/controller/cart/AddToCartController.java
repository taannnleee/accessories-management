package com.example.accessoriesmanagement.controller.cart;

import com.example.accessoriesmanagement.Mapper.Mappers;
import com.example.accessoriesmanagement.controller.DTO.ProductDTO;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.service.IProductService;
import com.example.accessoriesmanagement.service.IShoppingCartService;
import com.example.accessoriesmanagement.service.Impl.ProductServiceImpl;
import com.example.accessoriesmanagement.service.Impl.ShoppingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add_to_cart")
public class AddToCartController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    IShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String url = "view_cart";
            String product_id = req.getParameter("product_id");
            String quantity = req.getParameter("quantity");

            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("acc");
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

            if (user != null) {
                // Kiểm tra xem người dùng đã đăng nhập hay chưa
                if (shoppingCart == null || !user.getUserID().equals(shoppingCart.getUser().getUserID())) {
                    // Nếu đăng nhập với tài khoản mới hoặc chưa có giỏ hàng, tạo giỏ hàng mới
                    shoppingCart = new ShoppingCart();
                    shoppingCart.setUser(user);
                    shoppingCart.setShop_order(null);
                    shoppingCart.setTotalPrice(0);
                    session.setAttribute("shoppingCart", shoppingCart);
                }

                Long productId = Long.valueOf(product_id);
                ProductDTO productDTO = productService.getProductById(productId);



                ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
                shoppingCartItem.setProduct(Mappers.convertToEntity(productDTO, Product.class));
                shoppingCartItem.setShoppingCartItemQuantity(quantity);
                shoppingCartItem.setShopping_cart(shoppingCart);

                // Thêm shoppingCartItem vào shoppingCart
                List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();
                shoppingCartItems.add(shoppingCartItem);

                shoppingCart.setShoppingCartItems(shoppingCartItems);

                shoppingCartService.insertShoppingCart(shoppingCart);



                session.setAttribute("shoppingCart", shoppingCart);
                resp.sendRedirect(url);

            }
            else {
                url = "error";
                resp.sendRedirect(url);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Có lỗi xảy ra: " + e.getMessage()); // In ra thông điệp lỗi nếu cần
        }

    }
}
