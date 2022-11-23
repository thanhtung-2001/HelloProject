package com.fpt.edu.controller;

import com.fpt.edu.dao.UserDao;
import com.fpt.edu.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        UserDao uDao = new UserDao();
        User user = new User(userName,password);
        if(uDao.checkLogin(user)){
            System.out.println("Login success");
            session.setAttribute("user", user);
            RequestDispatcher rs = request.getRequestDispatcher("login-success.jsp");
            rs.forward(request,response);
        } else {
            System.out.println("Login failure");
//            RequestDispatcher rs = request.getRequestDispatcher("login-error.jsp");
//            rs.forward(request,response);
            response.sendRedirect("login-error.jsp");
        }
    }
}
