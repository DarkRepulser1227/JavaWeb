package com.iss.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        String name=request.getParameter("N");
        String pwd=request.getParameter("P");
        String str="";
        if (name.equalsIgnoreCase("bill") && pwd.equalsIgnoreCase("123")){
            str="{\"state\":\"true\",\"message\":\"登录成功!\"}";
        }else{
            str="{\"state\":\"false\",\"message\":\"用户名或密码错误!\"}";
        }

        out.print(str);
        out.flush();
        out.close();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
