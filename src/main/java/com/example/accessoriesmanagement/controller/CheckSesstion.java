//package com.example.accessoriesmanagement.controller;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class CheckSesstion implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        // Kiểm tra xem request có phải là trang đăng nhập không để tránh vòng lặp chuyển hướng
//        String loginURI = httpRequest.getContextPath() + "/login";
//        boolean isLoggedIn = httpRequest.getSession().getAttribute("acc") != null;
//        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
//
//        if (isLoggedIn || isLoginRequest) {
//            // Nếu đã đăng nhập hoặc đang truy cập trang đăng nhập, cho phép tiếp tục
//            chain.doFilter(request, response);
//        } else {
//            // Nếu chưa đăng nhập và không phải trang đăng nhập, chuyển hướng đến trang đăng nhập
//            httpResponse.sendRedirect(loginURI);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
