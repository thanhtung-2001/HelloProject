package com.fpt.edu.controller;

import com.fpt.edu.dao.NhaXuatBanDao;
import com.fpt.edu.model.NhaXuatBan;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "NhaXuatBanAddController", value = "/NhaXuatBanAdd")
public class NhaXuatBanAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhaXuatBan nhaXuatBan = new NhaXuatBan();
        nhaXuatBan.setTen(request.getParameter("ten"));
        nhaXuatBan.setDiachi(request.getParameter("diachi"));
        nhaXuatBan.setSdt(request.getParameter("sdt"));
        nhaXuatBan.setSofax(request.getParameter("sofax"));
        NhaXuatBanDao nhaXuatBanDao = new NhaXuatBanDao();
        if(nhaXuatBanDao.add(nhaXuatBan)){
            RequestDispatcher rs = request.getRequestDispatcher("nxb-list.jsp");
            request.setAttribute("listnxb",nhaXuatBanDao.getALl());
            rs.forward(request,response);
        } else {
            response.sendRedirect("nxb-form.jsp?error=1");
        }
    }
}
