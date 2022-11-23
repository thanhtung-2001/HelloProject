package com.fpt.edu.dao;

import com.fpt.edu.model.NhaXuatBan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaXuatBanDao {
    public boolean add(NhaXuatBan nxb){
        String sql = "insert into tbl_nxb(ten,diachi,sdt,sofax) values(?,?,?,?)";
        int output = -1;
        PreparedStatement ps=null;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1,nxb.getTen());
            ps.setString(2,nxb.getDiachi());
            ps.setString(3,nxb.getSdt());
            ps.setString(4,nxb.getSofax());
            output = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
        if(output>0) return true;
        return false;
//        return output > 0;
    }

    public List<NhaXuatBan> getALl(){
        List<NhaXuatBan> list = new ArrayList<>();
        String sql = "select id,ten,diachi,sdt,sofax from tbl_nxb";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                NhaXuatBan n = new NhaXuatBan();
                n.setId(rs.getInt(1));
                n.setTen(rs.getString(2));
                n.setDiachi(rs.getString(3));
                n.setSdt(rs.getString(4));
                n.setSofax(rs.getString(5));
                list.add(n);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public NhaXuatBan getByID(int id){
        NhaXuatBan n = null;
        String sql = "select id,ten,diachi,sdt,sofax from tbl_nxb where id = ?";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                n = new NhaXuatBan();
                n.setId(rs.getInt(1));
                n.setTen(rs.getString(2));
                n.setDiachi(rs.getString(3));
                n.setSdt(rs.getString(4));
                n.setSofax(rs.getString(5));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return n;
    }

    public boolean update(NhaXuatBan nhaXuatBan){
        String sql = "update tbl_nxb set ten= ?,diachi =?,sdt= ?,sofax=? where id = ?";
        int output = -1;
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, nhaXuatBan.getTen());
            ps.setString(2, nhaXuatBan.getDiachi());
            ps.setString(3, nhaXuatBan.getSdt());
            ps.setString(4, nhaXuatBan.getSofax());
            ps.setInt(5, nhaXuatBan.getId());
            output = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output > 0;
    }

    public boolean delete(int id){
        String sql = "delete from tbl_nxb where id = ?";
        int output =-1;
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
//    public static void main(String[] args) {
//        NhaXuatBanDao nhaXuatBanDao = new NhaXuatBanDao();
//        NhaXuatBan n = new NhaXuatBan(1,"Kim Dong2", "Cau Giay","0123123123","012341234");
//        System.out.println("them lan 1: ");
//        if(nhaXuatBanDao.add(n)){
//            System.out.println("Them nha xuat ban thanh cong");
//
//        }else{
//            System.out.println("Them nha xuat ban that bai");
//        }
//        System.out.println("them lan 2: ");
//        if(nhaXuatBanDao.add(n)){
//            System.out.println("Them nha xuat ban thanh cong");
//
//        }else{
//            System.out.println("Them nha xuat ban that bai");
//        }
//    }
}
