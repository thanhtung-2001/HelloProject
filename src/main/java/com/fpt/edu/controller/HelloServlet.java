package com.fpt.edu.controller;

import com.fpt.edu.utils.MathUtils;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String soa = request.getParameter("soa");
        String sob = request.getParameter("sob");
        PrintWriter out = response.getWriter();
        try {
            int iSoA = Integer.parseInt(soa);
            int iSoB = Integer.parseInt(sob);

            out.println("<html><body>");
            out.println("<h1>so a: " + soa +" la so nguyen to " +
                    MathUtils.isSoNguyenTo( iSoA) + "</h1>");
            out.println("<h1>so b: " + sob +" la so nguyen to " +
                    MathUtils.isSoNguyenTo( iSoB) + "</h1>");
            out.println("<h1>so a: " + soa +" la so chinh phuong " +
                    MathUtils.isChinhPhuong( iSoA) + "</h1>");
            out.println("<h1>so b: " + sob +" la so chinh phuong " +
                    MathUtils.isChinhPhuong( iSoB) + "</h1>");
            out.println("</body></html>");
        }catch (Exception e){
            out.println("Input Invalid");
        }
    }

    public void destroy() {
    }
}