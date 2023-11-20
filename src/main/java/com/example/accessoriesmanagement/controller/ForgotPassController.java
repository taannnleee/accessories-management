package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.mailSend.Mail;
import com.example.accessoriesmanagement.mailSend.EmailUtils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Servlet implementation class ForgotPasswordControl
 */
@WebServlet(name = "ForgotPasswordControl", urlPatterns = {"/forgotPassword"})
public class ForgotPassController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/ForgotPassword.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    private static String generateRandomPassword(int length) {
        // Chuỗi chứa tất cả các ký tự có thể sử dụng trong mật khẩu
        String characters = "0123456789";

        // Tạo một đối tượng Random
        Random random = new Random();

        // StringBuilder để xây dựng mật khẩu ngẫu nhiên
        StringBuilder password = new StringBuilder(length);

        // Tạo mật khẩu ngẫu nhiên bằng cách chọn ngẫu nhiên các ký tự từ chuỗi characters
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");

        try {
            String emailAddress = request.getParameter("email");
            String username = request.getParameter("username");

            String password = generateRandomPassword(6);
            Mail email =new Mail();
            email.setFrom("21110824@student.hcmute.edu.vn");
            email.setFromPassword("hauhau1512@");
            email.setTo(emailAddress);
            email.setSubject("Forgot Password Function");
            StringBuilder sb = new StringBuilder();
            sb.append("Dear ").append(username).append("<br>");
            sb.append("You are used the forgot password. <br> ");
            sb.append("Your new password is <b>").append(password).append(" </b> <br>");
            sb.append("Regards<br>");
            sb.append("Administrator");

            email.setContent(sb.toString());
            EmailUtils.send(email);

            request.setAttribute("mess", "Mat khau da duoc gui den email cua ban!");


            }
        catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("views/ForgotPassword.jsp").forward(request, response);
    }

}
