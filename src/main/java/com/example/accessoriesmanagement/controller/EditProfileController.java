package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.repositories.IUserRepository;
import com.example.accessoriesmanagement.repositories.Impl.UserRepositoryImpl;
import com.example.accessoriesmanagement.entity.User;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditProfileControl", urlPatterns = {"/editProfile"})
public class EditProfileController extends HttpServlet {

    private final IUserRepository userDao = new UserRepositoryImpl();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("acc");
        Long id = a.getUserID();

        String dateOfBirthStr = request.getParameter("dateOfBirth");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");

        Date dateOfBirth = null;
        try {
            if (dateOfBirthStr != null && !dateOfBirthStr.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dateOfBirth = sdf.parse(dateOfBirthStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (email != null && firstName != null && lastName != null && phone != null && dateOfBirth != null) {
            userDao.editProfile(dateOfBirth,email, firstName, lastName, phone, id);
            request.setAttribute("mess", "Update successfully!");
        } else {
            request.setAttribute("mess", "Please fill the textbox to update!");
        }
        User updatedUser = userDao.getUserById(id);

        session.setAttribute("acc", updatedUser);

        request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
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

}
