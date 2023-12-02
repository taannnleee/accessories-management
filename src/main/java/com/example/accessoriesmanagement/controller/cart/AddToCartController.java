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

            Long productId = Long.valueOf(product_id);
            ProductDTO productDTO = productService.getProductById(productId);

            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("acc");
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

            if (user != null) {
                if (shoppingCart == null) {
                    // Nếu đăng nhập với tài khoản mới hoặc chưa có giỏ hàng, tạo giỏ hàng mới
                    shoppingCart = new ShoppingCart();
                    shoppingCart.setUser(user);
                    shoppingCart.setShop_order(null);
                    shoppingCart.setTotalPrice(0);
                    // Lưu giỏ hàng vào session
                    session.setAttribute("shoppingCart", shoppingCart);
                }
                else if(!user.getUserID().equals(shoppingCart.getUser().getUserID())){
                    shoppingCart = shoppingCartService.getShoppingCartById(user.getShoppingCart().getShoppingId());
                }
                else {
                    shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
                }

                // Tạo ShoppingCartItem và thêm vào giỏ hàng
                ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
                shoppingCartItem.setProduct(Mappers.convertToEntity(productDTO, Product.class));
                shoppingCartItem.setShoppingCartItemQuantity(quantity);
                shoppingCartItem.setShopping_cart(shoppingCart);

                ShoppingCartItem updateShoppingCartItem = shoppingCartItemService.updateShoppingCartItem(shoppingCartItem);

                //Trong lần đầu đăng nhập thì null để tạo cart mới. set lại cart hiện tại để nó không tự động tạo ra cart mơi
                if(shoppingCart==null || shoppingCart.getShoppingId()==null){
                    shoppingCart = updateShoppingCartItem.getShopping_cart();
                }

                // Cập nhật giỏ hàng trong session
                session.setAttribute("shoppingCart", shoppingCart);
                session.setAttribute("acc", user);
////////////////////////////////////////////////////////////////////


                //Cập nhật lại user theoID
                User user_update = userService.getUserById(user.getUserID());

                //lấy shopping tu user
                ShoppingCart shoppingCart1 =  shoppingCartService.getShoppingCartById(user_update.getShoppingCart().getShoppingId());


                //lay shopingCartItem theo shoppingCart
                List<ShoppingCartItem> shoppingCartItems = shoppingCart1.getShoppingCartItems();

                List<Product> productBuys = new ArrayList<>();
                for(ShoppingCartItem s :shoppingCartItems){
                    ProductDTO productDTO1 =  productService.getProductById(s.getProduct().getProductID());
                    Product productBuy = Mappers.convertToEntity(productDTO1,Product.class);
                    productBuys.add(productBuy);
                }
                req.setAttribute("productBuys",productBuys);

                for(Product p :productBuys){
                    System.out.println(p.getProductName());
                }


                RequestDispatcher errorDispatcher = req.getRequestDispatcher("/cart.jsp");
                errorDispatcher.forward(req, resp);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Có lỗi xảy ra: " + e.getMessage()); // In ra thông điệp lỗi nếu cần
        }

    }
}
