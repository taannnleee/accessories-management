package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.repositories.IUserRepository;
import com.example.accessoriesmanagement.repositories.UserRepositoryImpl;
import com.example.accessoriesmanagement.entity.User;

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

    private final IUserRepository userDao = new UserRepositoryImpl();

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
