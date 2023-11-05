package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.DAO.IProductDao;
import com.example.accessoriesmanagement.DAO.ProductDaoImpl;
import com.example.accessoriesmanagement.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ProductController extends HttpServlet {
    IProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String url = "/index.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "display_users";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("display_users")) {
            // get list of users
            List<User> users = ProductDaoImpl.selectUsers();
            request.setAttribute("users", users);
        }
        else if (action.equals("display_user")) {
            String emailAddress = request.getParameter("email");
            User user = productDao.selectUser(emailAddress);
            session.setAttribute("user", user);
            url = "/user.jsp";
        }
        else if (action.equals("update_user")) {
            // get parameters from the request
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            // get and update user
            User user = (User) session.getAttribute("user");
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            ProductDaoImpl.update(user);

            // get and set updated users
            List<User> users = ProductDaoImpl.selectUsers();
            request.setAttribute("users", users);
        }
        else if (action.equals("delete_user")) {
            // get the user
            String email = request.getParameter("email");
            User user = productDao.selectUser(email);

            // delte the user
            ProductDaoImpl.delete(user);

            // get and set updated users
            List<User> users = ProductDaoImpl.selectUsers();
            request.setAttribute("users", users);
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
