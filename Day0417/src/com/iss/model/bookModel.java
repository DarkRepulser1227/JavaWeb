package com.iss.model;

import com.iss.po.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class bookModel {

    public static boolean upBook(Connection con,String bid,String bname, String author, String price){
        boolean b=false;
        try {
            String sql="update books set bname=?,author=?,price=? where bid=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,bname);
            ps.setString(2,author);
            ps.setFloat(3,Float.parseFloat(price));
            ps.setString(4,bid);
            ps.execute();
            b=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public static ResultSet getBookDetail(Connection con,String bid){
        ResultSet rs=null;
        try {
            String sql="select * from books where bid=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,bid);
            rs=ps.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void delBook(Connection con,String bid){
        try {
            String sql="delete from books where bid=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,bid);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getBooks(Connection con){
        ResultSet rs=null;

        try {
            String sql="select * from books";
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
}
