package com.iss.demo;

import com.iss.model.UserModel;
import com.iss.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            String name=request.getParameter("n").toString();
            String pwd=request.getParameter("p").toString();
//        System.out.println(name);
//        System.out.println(pwd);

            //懒人的写法
            //response.getWriter().append(name);
            int x=UserModel.userLogin(DBUtil.getConnection(),name,pwd);
            PrintWriter out=response.getWriter();
            out.print(x);
            out.flush();
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        DBUtil.getConnection();
    }
}
