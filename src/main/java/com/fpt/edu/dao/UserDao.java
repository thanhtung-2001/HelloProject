package com.fpt.edu.dao;

import com.fpt.edu.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public boolean checkLogin(User user){

//        if("sa".equals(user.getUsername()) && "sa".equals(user.getPassword()))
//            return true;
//        return false;
        Boolean output = false;
        String sql = "select username from tbl_user where username = ? and password = ?";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                output= true;
//                return true;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
}
