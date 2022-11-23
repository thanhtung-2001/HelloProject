package com.fpt.edu.dao;

import com.fpt.edu.model.TheLoai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiDao {
    public boolean add(TheLoai theLoai) {
        Connection con = DBConnection.getConnection();
        String sql = "insert into tbl_theloai(ten) values (?)";
        PreparedStatement ps = null;
        int output = -1;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, theLoai.getTen());
            output = ps.executeUpdate();
            if(ps!=null){
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output > 0;
    }

    public List<TheLoai> getAll(){
        List<TheLoai> list = new ArrayList<>();
        String sql = "select id, ten from tbl_theloai";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TheLoai t = new TheLoai();
                t.setId(rs.getInt(1));
                t.setTen(rs.getString(2));

                list.add(t);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public TheLoai getByID(int id) {
        TheLoai t = null;
        String sql = "select id, ten from tbl_theloai where id = ?";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new TheLoai();
                t.setId(rs.getInt(1));
                t.setTen(rs.getString(2));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    public boolean update(TheLoai theLoai) {
        String sql = "update tbl_theloai set ten=? where id=?";
        int output = -1;
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, theLoai.getTen());
            ps.setInt(2, theLoai.getId());

            output = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output > 0;
    }

    public boolean delete(int id){
        String sql = "delete from tbl_theloai where id=?";
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
