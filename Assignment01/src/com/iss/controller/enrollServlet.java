package com.iss.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author By gaojiaming1227@gmail.com Employer Gao
 * @date 2019/4/22
 */
@WebServlet("/enrollServlet")
public class enrollServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String uname = request.getParameter("UNAME");
        String upwd = request.getParameter("UPWD");
        String gander = request.getParameter("GANDER");
        String date = request.getParameter("DATE");
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String email = request.getParameter("EMAIL");
        String str = "";


        str = uname + upwd + gander  + date  + email;
        out.print(str);
        str = uname + "\n" + upwd + "\n" + gander + "\n" + date + "\n" + email;
        System.out.println(str);
        out.flush();
        out.close();


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
