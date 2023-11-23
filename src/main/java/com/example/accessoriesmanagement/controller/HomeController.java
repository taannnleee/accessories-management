package com.example.accessoriesmanagement.controller;

import com.example.accessoriesmanagement.controller.DTO.ProductDTO;
import com.example.accessoriesmanagement.service.IProductService;
import com.example.accessoriesmanagement.service.Impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "HomeControl", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        List<ProductDTO> products = productService.selectProduct();
        request.setAttribute("products", products);
        request.getRequestDispatcher("views/Home.jsp").forward(request, response);


    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


//    private String checkUser(HttpServletRequest request,
//                             HttpServletResponse response) {
//
//        String productCode = request.getParameter("productCode");
//        HttpSession session = request.getSession();
//        session.setAttribute("productCode", productCode);
//        User user = (User) session.getAttribute("user");
//
//        String url;
//        // if User object doesn't exist, check email cookie
//        if (user == null) {
//            Cookie[] cookies = request.getCookies();
//            String emailAddress =
//                    CookieUtil.getCookieValue(cookies, "emailCookie");
//
//
//            if (emailAddress == null || emailAddress.equals("")) {
//                url = "/register.jsp";
//            }
//
//            else {
//                ServletContext sc = getServletContext();
//                String path = sc.getRealPath("/WEB-INF/EmailList.txt");
//                user = UserIO.getUser(emailAddress, path);
//                session.setAttribute("user", user);
//                url = "/" + productCode + "_download.jsp";
//            }
//        }
//
//        else {
//            url = "/" + productCode + "_download.jsp";
//        }
//        return url;
//    }
//
//    private String registerUser(HttpServletRequest request,
//                                HttpServletResponse response) {
//
//        String url = "/register.jsp";
//
//        String email = request.getParameter("email");
//        String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
//
//
//        User user = new User();
//        user.setEmail(email);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//
//
//        ServletContext sc = getServletContext();
//        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
//
//        boolean emailExists = UserIO.checkEmailExistence(email, path);
//
//        if(!emailExists){
//            UserIO.add(user, path);
//
//
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//
//
//            Cookie c1 = new Cookie("emailCookie",email);
//            c1.setMaxAge(60 * 60 * 24 * 365 * 2); // set age to 2 years
//            c1.setPath("/");
//            response.addCookie(c1);
//
//            // add a cookie that stores the user's as a cookie
//            Cookie c2 = new Cookie("firstNameCookie", firstName);
//            c2.setMaxAge(60 * 60 * 24 * 365 * 2); // set age to 2 years
//            c2.setPath("/");
//            response.addCookie(c2);
//
//
//            String productCode = (String) session.getAttribute("productCode");
//            url = "/" + productCode + "_download.jsp";
//
//        }
//        else {
//            url = "/register.jsp";
//        }
//
//        return url;
//
//    }
}
