package com.fpt.edu.controller;

import com.fpt.edu.dao.BookDao;
import com.fpt.edu.dao.NhaXuatBanDao;
import com.fpt.edu.dao.TheLoaiDao;
import com.fpt.edu.model.Book;
import com.fpt.edu.model.NhaXuatBan;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BookController", value = "/Books")
public class BookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        String keyword = request.getParameter("keyword");
        if(method == null){
            method="index";
        }
        String book_id = request.getParameter("book_id");
        RequestDispatcher rs = null;
        BookDao bookDao = new BookDao();
        NhaXuatBanDao nhaXuatBanDao = new NhaXuatBanDao();
        TheLoaiDao theLoaiDao = new TheLoaiDao();
        switch (method){
            case "new":
                request.setAttribute("listnxb",nhaXuatBanDao.getALl());
                request.setAttribute("listtheloai",theLoaiDao.getAll());
                rs = request.getRequestDispatcher("book/book-new.jsp");
                break;
            case "edit":
                request.setAttribute("listnxb",nhaXuatBanDao.getALl());
                request.setAttribute("listtheloai",theLoaiDao.getAll());
                Book book = bookDao.getByID(Integer.parseInt(book_id));
                request.setAttribute("book",book);
                rs = request.getRequestDispatcher("book/book-edit.jsp");
                break;
            case "delete":
                bookDao.delete(Integer.parseInt(book_id));
                request.setAttribute("listbook",bookDao.getAll());
                rs = request.getRequestDispatcher("book/book-list.jsp");
                break;
            default:
                request.setAttribute("listbook",bookDao.getAll());
                rs = request.getRequestDispatcher("book/book-list.jsp");
        }
        rs.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method == null){
            method="index";
        }
        RequestDispatcher rs = null;
        BookDao bookDao = new BookDao();
        switch (method){
            case "add":
                Book b = new Book();
                b.setTen(request.getParameter("ten"));
                b.setTacgia(request.getParameter("tacgia"));
                b.setNxb_id(Integer.parseInt(request.getParameter("nxb_id")));
                b.setGiaban(Float.parseFloat(request.getParameter("giaban")));
                NhaXuatBan n = new NhaXuatBan();
                bookDao.add(b);
                break;
            case "update":
                Book b2 = new Book();
                String id = request.getParameter("id");
                b2.setId(Integer.parseInt(id));
                b2.setTen(request.getParameter("ten"));
                b2.setTacgia(request.getParameter("tacgia"));
                b2.setTheloai_id(Integer.parseInt(request.getParameter("theloai_id")));
                b2.setNxb_id(Integer.parseInt(request.getParameter("nxb_id")));
                b2.setGiaban(Float.parseFloat(request.getParameter("giaban")));
                bookDao.update(b2);
                break;
//            default:
//TODO create bookDao.getAll();
//                request.setAttribute("listbooks", bookDao.getALl());
        }
        response.sendRedirect("Books");
    }
}
