package com.fpt.edu.controller;

import com.fpt.edu.dao.TheLoaiDao;
import com.fpt.edu.model.TheLoai;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "TheLoaiController", value = "/TheLoais")
public class TheLoaiController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        method = method == null ? "index" : method;
        String tl_id = request.getParameter("tl_id");
        TheLoaiDao theLoaiDao = new TheLoaiDao();
        RequestDispatcher rs;
        switch (method) {
            case "new":
                request.setAttribute("listtheloai",theLoaiDao.getAll());
                rs = request.getRequestDispatcher("theloai/tl-form.jsp");
                break;
            case "edit":
                TheLoai theLoai = theLoaiDao.getByID(Integer.parseInt(tl_id));
                request.setAttribute("theLoai",theLoai);
                rs = request.getRequestDispatcher("theloai/tl-edit.jsp");
                break;
            case "delete":
                theLoaiDao.delete(Integer.parseInt(tl_id));
                request.setAttribute("listtheloai",theLoaiDao.getAll());
                rs = request.getRequestDispatcher("theloai/tl-list.jsp");
                break;
            default:
                request.setAttribute("listtheloai",theLoaiDao.getAll());
                rs = request.getRequestDispatcher("theloai/tl-list.jsp");
                break;
        }
        rs.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method == null) {
            response.sendRedirect("TheLoais");
            return;
//            return doGet(request, response);
        }
        TheLoaiDao theLoaiDao = new TheLoaiDao();
        switch (method) {
            case "add":
                TheLoai theLoai = new TheLoai();
                // lay thong tin tu request cap nhat vao doi tuong theLoai
                theLoai.setTen(request.getParameter("ten"));
                theLoaiDao.add(theLoai);
                break;
            case "update":
                TheLoai theLoai2 = new TheLoai();
                // lay thong tin tu request cap nhat vao doi tuong the loai
                String id = request.getParameter("id");
                theLoai2.setId(Integer.parseInt(id));
                theLoai2.setTen(request.getParameter("ten"));
                theLoaiDao.update(theLoai2);
                break;
//            default:
//                request.setAttribute("listnxb", nhaXuatBanDao.getAll());
//                break;
        }
        response.sendRedirect("TheLoais");
    }
}
