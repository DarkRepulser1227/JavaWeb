package com.iss.model;

import com.iss.entity.Users;
import com.iss.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserModel {

    public static void addUser(Connection con,Users user){
        try {
            String sql="INSERT INTO users VALUES (?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,user.getUname());
            ps.setString(2,user.getUpwd());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int userLogin(Connection con, String username, String password){
        int x=0;
        try {
            String sql="SELECT COUNT(*) FROM users WHERE uname=? AND upwd=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs=ps.executeQuery();

            if (rs.next()){
                x=rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            x=-1;
        }
        return x;
    }
}
