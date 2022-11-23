package com.fpt.edu.dao;

import com.fpt.edu.model.Book;
import com.fpt.edu.model.NhaXuatBan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public boolean add(Book book){
        Connection con = DBConnection.getConnection();
        String sql = "insert into tbl_books(ten, tacgia, theloai_id, nxb_id, giaban) values(?,?,?,?,?)";
        PreparedStatement ps = null;
        int output = -1;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,book.getTen());
            ps.setString(2,book.getTacgia());
            ps.setInt(3,book.getTheloai_id());
            ps.setInt(4,book.getNxb_id());
            ps.setFloat(5,book.getGiaban());
            output = ps.executeUpdate();
            if(ps!=null){
                ps.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return output > 0;
    }

    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "select id, ten, tacgia, theloai_id, nxb_id, giaban from tbl_books";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Book b = new Book();
                b.setId(rs.getInt(1));
                b.setTen(rs.getString(2));
                b.setTacgia(rs.getString(3));
                b.setTheloai_id(rs.getInt(4));
                b.setNxb_id(rs.getInt(5));
                b.setGiaban(rs.getFloat(6));
                list.add(b);
            }
            rs.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Book getByID(int id){
        Book b = null;
        String sql = "select id, ten, tacgia, theloai_id, nxb_id, giaban from tbl_books where id = ?";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                b = new Book();
                b.setId(rs.getInt(1));
                b.setTen(rs.getString(2));
                b.setTacgia(rs.getString(3));
                b.setTheloai_id(rs.getInt(4));
                b.setNxb_id(rs.getInt(5));
                b.setGiaban(rs.getFloat(6));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return b;
    }

    public boolean update(Book book){
        String sql = "update tbl_books set ten=?, tacgia=?, theloai_id=?, nxb_id=?, giaban=? where id=?";
        int output = -1;
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, book.getTen());
            ps.setString(2, book.getTacgia());
            ps.setInt(3, book.getTheloai_id());
            ps.setInt(4, book.getNxb_id());
            ps.setFloat(5, book.getGiaban());
            output = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output > 0;
    }

    public boolean delete(int id){
        String sql = "delete from tbl_books where id=?";
        int output = -1;
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            output = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output > 0;
    }
}
