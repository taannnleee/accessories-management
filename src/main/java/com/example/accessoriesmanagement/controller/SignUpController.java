package com.example.accessoriesmanagement.controller;
import com.example.accessoriesmanagement.DAO.IUserDao;
import com.example.accessoriesmanagement.DAO.UserDaoImpl;
import com.example.accessoriesmanagement.entity.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUpControl", urlPatterns = {"/signup"})
public class SignUpController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        String email = request.getParameter("email");

        if (!pass.equals(re_pass)) {
            response.sendRedirect("Login.jsp");
        } else {
            IUserDao userDao = new UserDaoImpl();

            User existingUser = userDao.checkAccountExist(user);

            if (existingUser == null) {
                userDao.signup(user, pass, email);
                response.sendRedirect("login");
            } else {
                response.sendRedirect("Login.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
