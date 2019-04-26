package com.iss.util;

import java.sql.*;

public class DBUtil {
    private static  Connection con=null;
    public static Connection getConnection(){
        try {
            if (con==null){
                Class.forName(PropertiesUtil.getValue("drvier"));
                con=DriverManager.getConnection(
                        PropertiesUtil.getValue("url"),
                        PropertiesUtil.getValue("username"),
                        PropertiesUtil.getValue("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
