package com.example.accessoriesmanagement.controller.cart;

import com.example.accessoriesmanagement.Mapper.Mappers;
import com.example.accessoriesmanagement.controller.DTO.ProductDTO;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.repositories.IUserRepository;
import com.example.accessoriesmanagement.repositories.Impl.UserRepositoryImpl;
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

@WebServlet("/view_cart")
public class CartController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    IShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    IShoppingCartItemService shoppingCartItemService = new ShoppingCartItemServiceImpl();

    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("acc");

            //Cập nhật lại user theoID
            User user_update = userService.getUserById(user.getUserID());

            //lấy shopping tu user
            ShoppingCart shoppingCart =  shoppingCartService.getShoppingCartById(user_update.getShoppingCart().getShoppingId());


            //lay shopingCartItem theo shoppingCart
            List<ShoppingCartItem> shoppingCartItems = shoppingCart.getShoppingCartItems();

            List<ShoppingCartItem> productBuys = new ArrayList<>();
            for(ShoppingCartItem s :shoppingCartItems){
                ProductDTO productDTO =  productService.getProductById(s.getProduct().getProductID());
                Product productBuy = Mappers.convertToEntity(productDTO,Product.class);
                productBuys.add(s);
            }
            req.setAttribute("productBuys",productBuys);

//            for(Product p :productBuys){
//                System.out.println(p.getProductName());
//            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/cart.jsp");
            dispatcher.forward(req, resp);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Có lỗi xảy ra: " + e.getMessage()); // In ra thông điệp lỗi nếu cần
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
