package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.repositories.IUserDao;
import com.example.accessoriesmanagement.repositories.Impl.UserDaoImpl;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.service.IShoppingCartService;
import com.example.accessoriesmanagement.service.Impl.ShoppingCartServiceImpl;

import java.io.IOException;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginControl", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private final IUserDao userDao = new UserDaoImpl();

    IShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Bước 1: Lấy user, pass từ cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userC")) {
                    request.setAttribute("username", cookie.getValue());
                }
                if (cookie.getName().equals("passC")) {
                    request.setAttribute("password", cookie.getValue());
                }
            }
        }

        request.getRequestDispatcher("views/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String remember = request.getParameter("remember");

        try {
            User user = userDao.authenticateUser(username, password);

            if (user == null) {
                request.setAttribute("error", "Sai username hoặc password!");
                request.getRequestDispatcher("views/Login.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("acc", user);

//                User user_temp = (User) session.getAttribute("acc");
//                user =  userDao.getUserById(user_temp.getUserID());
//                if(user.getShoppingCart() == null){
//                    ShoppingCart shoppingCart = new ShoppingCart();
//                    shoppingCart.setUser(user);
//                    shoppingCart.setTotalPrice(0);
//                    shoppingCartService.insertShoppingCart(shoppingCart);
//
//                    session.setAttribute("shoppingCart", shoppingCart);
//                    session.setAttribute("acc", user);
//                }
//                else {
//                    ShoppingCart shoppingCart = user.getShoppingCart();
//                    session.setAttribute("shoppingCart", shoppingCart);
//                    session.setAttribute("acc", user);
//                }


                session.setMaxInactiveInterval(60 * 60 * 24);

                // Lưu user vào cookie
                Cookie u = new Cookie("userC", username);
                Cookie p = new Cookie("passC", password);

                if (remember != null) {
                    p.setMaxAge(60 * 60 * 24);
                } else {
                    p.setMaxAge(0);
                }

                u.setMaxAge(60 * 60 * 24 * 365); // 1 năm

                response.addCookie(u);
                response.addCookie(p);

                response.sendRedirect("home");
            }
        } catch (NoResultException e) {
            request.setAttribute("error", "Sai username hoặc password!");
            request.getRequestDispatcher("views/Login.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
