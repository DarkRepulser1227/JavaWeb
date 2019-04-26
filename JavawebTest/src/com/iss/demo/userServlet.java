package com.iss.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//sql包

@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            设置编码格式
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
//        根据id或name获得前台数据
            String name = request.getParameter("n").toString();
            String pwd = request.getParameter("p").toString();
//        System.out.println(name);
//        System.out.println(pwd);
//        向前台发送数据
//              懒人写法
            response.getWriter().append(name);
//              闲人写法
            PrintWriter out = response.getWriter();
            out.print(name);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
